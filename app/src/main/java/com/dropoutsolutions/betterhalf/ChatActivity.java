package com.dropoutsolutions.betterhalf;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.StorageTask;
import com.google.firebase.storage.UploadTask;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.DexterError;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.PermissionRequestErrorListener;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;
import com.karumi.dexter.listener.single.PermissionListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import de.hdodenhof.circleimageview.CircleImageView;

public class ChatActivity extends AppCompatActivity {

    EditText inputmessage ;
    private String recieverid , Senderid ;
    private DatabaseReference chatref ;
    private DatabaseReference userref ;
    private FirebaseAuth auth ;
    private ImageView sendmessage;
    String myurl ;
    CircleImageView profileimage ;
    TextView name ;
    private String CurrentDate , CurrentTime ;
    private ImageView addfile ;
    private ProgressDialog progressDialog ;
    private String checker = "";
    ImageView backimage ;
    private Uri imageuri ;
    RecyclerView recyclerView ;
    private LinearLayoutManager linearLayoutManager ;
    private MessageAdapter messageAdapter ;
    private StorageTask uploadtask ;
    private StorageReference postimages ;
    private final List<Messages> messagesList = new ArrayList<>() ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        progressDialog = new ProgressDialog(this);
        auth = FirebaseAuth.getInstance() ;
        Senderid = auth.getCurrentUser().getUid() ;
        sendmessage = findViewById(R.id.sendmessage);
        addfile = findViewById(R.id.add);
        profileimage = findViewById(R.id.profileimage);
        name = findViewById(R.id.username);
        backimage = findViewById(R.id.backimage);
        recyclerView = findViewById(R.id.recyclerview);
        userref = FirebaseDatabase.getInstance().getReference().child("Users");
        chatref = FirebaseDatabase.getInstance().getReference();
        recieverid = getIntent().getExtras().get("Userid").toString();
        inputmessage = findViewById(R.id.inputmessage);

        profileimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChatActivity.this  , OnclickDetails.class);
                intent.putExtra("Userid" , recieverid);
                startActivity(intent);
            }
        });

        backimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        sendmessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Sendmessages();
            }
        });

        addfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requestStoragePermission();
            }
        });

        messageAdapter = new MessageAdapter(messagesList , this);
        linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setStackFromEnd(true);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(messageAdapter);

        fetchmessage();


    }
    private void fetchmessage() {

        chatref.child("Messages").child(Senderid).child(recieverid).addChildEventListener(
                new ChildEventListener() {
                    @Override
                    public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                        if (dataSnapshot.exists())
                        {
                            Messages messages = dataSnapshot.getValue(Messages.class);
                            messagesList.add(messages);
                            messageAdapter.notifyDataSetChanged();

                        }

                    }

                    @Override
                    public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                    }

                    @Override
                    public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

                    }

                    @Override
                    public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                }
        );
    }

    private void Sendmessages() {
        String messagetext = inputmessage.getText().toString();

        if (TextUtils.isEmpty(messagetext)) {
            inputmessage.setError("Please Write Message");
        } else {
            String messagesenderref = "Messages/" + Senderid + "/" + recieverid;
            String messagerecieverref = "Messages/" + recieverid + "/" + Senderid;

            DatabaseReference usermessageref = chatref.child("Messages").child(Senderid)
                    .child(recieverid).push();
            String messagepushid = usermessageref.getKey();

            Calendar calendarfordate = Calendar.getInstance();
            SimpleDateFormat currentdate = new SimpleDateFormat("dd MMMM");
            CurrentDate = currentdate.format(calendarfordate.getTime());

            Calendar calendarfortime = Calendar.getInstance();
            SimpleDateFormat currenttime = new SimpleDateFormat("HH:mm");
            CurrentTime = currenttime.format(calendarfortime.getTime());

            Map messagebody = new HashMap();
            messagebody.put("message", messagetext);
            messagebody.put("time", CurrentTime);
            messagebody.put("date", CurrentDate);
            messagebody.put("type", "text");
            messagebody.put("from", Senderid);
            messagebody.put("to", recieverid);
            messagebody.put("messageid", messagepushid);

            Map messagedetail = new HashMap();
            messagedetail.put(messagesenderref + "/" + messagepushid, messagebody);
            messagedetail.put(messagerecieverref + "/" + messagepushid, messagebody);

            chatref.updateChildren(messagedetail).addOnCompleteListener(new OnCompleteListener() {
                @Override
                public void onComplete(@NonNull Task task) {
                    if (task.isSuccessful()) {
                        inputmessage.setText(null);
                    } else {
                        Toast.makeText(ChatActivity.this, task.getException().toString(), Toast.LENGTH_SHORT).show();
                        inputmessage.setText(null);
                    }
                }
            });
        }
    }
    private void requestStoragePermission() {
        Dexter.withActivity(this)
                .withPermissions(
                        Manifest.permission.READ_EXTERNAL_STORAGE,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        Manifest.permission.ACCESS_FINE_LOCATION)
                .withListener(new MultiplePermissionsListener() {
                    @Override
                    public void onPermissionsChecked(MultiplePermissionsReport report) {
                        // check if all permissions are granted
                        if (report.areAllPermissionsGranted()) {
                            requestCameraPermission();
                            Toast.makeText(getApplicationContext(), "All permissions are granted!", Toast.LENGTH_SHORT).show();
                            CharSequence options[] = new CharSequence[]
                                    {
                                            "Images",
                                            "PDF File",
                                            "Word File"
                                    };
                            AlertDialog.Builder builder = new AlertDialog.Builder(ChatActivity.this);
                            builder.setTitle("Select Options");
                            builder.setItems(options, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    if (which == 0)
                                    {
                                        checker = "image";
                                        Intent galleryintent = new Intent();
                                        galleryintent.setAction(Intent.ACTION_GET_CONTENT);
                                        galleryintent.setType("image/*");
                                        startActivityForResult(galleryintent.createChooser(galleryintent ,"Select Image") ,438);

                                    }
                                    if (which == 1)
                                    {
                                        checker = "pdf";
                                        Intent galleryintent = new Intent();
                                        galleryintent.setAction(Intent.ACTION_GET_CONTENT);
                                        galleryintent.setType("application/pdf");
                                        startActivityForResult(galleryintent.createChooser(galleryintent ,"Select pdf file") ,438);
                                    }
                                    if (which == 2)
                                    {
                                        checker = "docx";
                                        Intent galleryintent = new Intent();
                                        galleryintent.setAction(Intent.ACTION_GET_CONTENT);
                                        galleryintent.setType("application/wsword");
                                        startActivityForResult(galleryintent.createChooser(galleryintent ,"Select word file") ,438);
                                    }

                                }
                            });
                            builder.show();
                        }

                        // check for permanent denial of any permission
                        if (report.isAnyPermissionPermanentlyDenied()) {
                            // show alert dialog navigating to Settings
                            showSettingsDialog();
                        }
                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(List<PermissionRequest> permissions, PermissionToken token) {
                        token.continuePermissionRequest();
                    }
                }).
                withErrorListener(new PermissionRequestErrorListener() {
                    @Override
                    public void onError(DexterError error) {
                        Toast.makeText(getApplicationContext(), "Error occurred! ", Toast.LENGTH_SHORT).show();
                    }
                })
                .onSameThread()
                .check();
    }

    private void requestCameraPermission() {
        Dexter.withActivity(this)
                .withPermission(Manifest.permission.CAMERA)
                .withListener(new PermissionListener() {
                    @Override
                    public void onPermissionGranted(PermissionGrantedResponse response) {
                        // permission is granted

                    }

                    @Override
                    public void onPermissionDenied(PermissionDeniedResponse response) {
                        // check for permanent denial of permission
                        if (response.isPermanentlyDenied()) {
                            showSettingsDialog();
                        }
                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(PermissionRequest permission, PermissionToken token) {
                        token.continuePermissionRequest();
                    }
                }).check();
    }

    private void showSettingsDialog() {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(ChatActivity.this);
        builder.setTitle("Need Permissions");
        builder.setMessage("This app needs permission to use this feature. You can grant them in app settings.");
        builder.setPositiveButton("GOTO SETTINGS", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
                openSettings();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        builder.show();

    }

    // navigating user to app settings
    private void openSettings() {
        Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        Uri uri = Uri.fromParts("package", getPackageName(), null);
        intent.setData(uri);
        startActivityForResult(intent, 101);
    }

    private void openCamera() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, 100);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 438 && resultCode == RESULT_OK && data.getData() != null) {
            progressDialog.setTitle("Uploading Image");
            progressDialog.setMessage("Please wait while we are sending image.....");
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();

            imageuri = data.getData();

            if (!checker.equals("image")) {
                postimages = FirebaseStorage.getInstance().getReference().child("Documents");
                final String messagesenderref = "Messages/" + Senderid + "/" + recieverid;
                final String messagerecieverref = "Messages/" + recieverid + "/" + Senderid;

                DatabaseReference usermessageref = chatref.child("Messages").child(Senderid)
                        .child(recieverid).push();
                final String messagepushid = usermessageref.getKey();


                final StorageReference fileref = postimages.child(messagepushid + "." + checker);
                fileref.putFile(imageuri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        final Task<Uri> firebaseUri = taskSnapshot.getStorage().getDownloadUrl();
                        firebaseUri.addOnSuccessListener(new OnSuccessListener<Uri>() {
                            @Override
                            public void onSuccess(Uri uri) {

                                myurl = uri.toString();
                            }
                        }).addOnCompleteListener(new OnCompleteListener() {
                            @Override
                            public void onComplete(@NonNull Task task) {

                                if (task.isSuccessful()) {
                                    Map messagebody = new HashMap();
                                    messagebody.put("message", myurl);
                                    messagebody.put("name", imageuri.getLastPathSegment());
                                    messagebody.put("time", CurrentTime);
                                    messagebody.put("date", CurrentDate);
                                    if (checker.equals("pdf")) {
                                        messagebody.put("type", checker);
                                    } else {
                                        messagebody.put("type", checker);
                                    }
                                    messagebody.put("from", Senderid);
                                    messagebody.put("to", recieverid);
                                    messagebody.put("messageid", messagepushid);

                                    Map messagedetail = new HashMap();
                                    messagedetail.put(messagesenderref + "/" + messagepushid, messagebody);
                                    messagedetail.put(messagerecieverref + "/" + messagepushid, messagebody);

                                    chatref.updateChildren(messagedetail).addOnCompleteListener(new OnCompleteListener() {
                                        @Override
                                        public void onComplete(@NonNull Task task) {
                                            if (task.isSuccessful()) {
                                                progressDialog.dismiss();
                                                Toast.makeText(ChatActivity.this, "Sent", Toast.LENGTH_SHORT).show();
                                                inputmessage.setText(null);
                                            } else {
                                                progressDialog.dismiss();
                                                Toast.makeText(ChatActivity.this, task.getException().toString(), Toast.LENGTH_SHORT).show();
                                                inputmessage.setText(null);
                                            }
                                        }
                                    });
                                }

                            }
                        });


                    }
                });


            } else if (checker.equals("image")) {
                Calendar calendarfordate = Calendar.getInstance();
                SimpleDateFormat currentdate = new SimpleDateFormat("dd-MMMM-yyyy");
                CurrentDate = currentdate.format(calendarfordate.getTime());
                Calendar calendarfortime = Calendar.getInstance();
                SimpleDateFormat currenttime = new SimpleDateFormat("HH:mm:ss");
                CurrentTime = currenttime.format(calendarfortime.getTime());
                postimages = FirebaseStorage.getInstance().getReference().child("message photo");
                final String messagesenderref = "Messages/" + Senderid + "/" + recieverid;
                final String messagerecieverref = "Messages/" + recieverid + "/" + Senderid;

                DatabaseReference usermessageref = chatref.child("Messages").child(Senderid)
                        .child(recieverid).push();
                final String messagepushid = usermessageref.getKey();


                final StorageReference fileref = postimages.child(messagepushid + "." + checker);
                fileref.putFile(imageuri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        final Task<Uri> firebaseUri = taskSnapshot.getStorage().getDownloadUrl();
                        firebaseUri.addOnSuccessListener(new OnSuccessListener<Uri>() {
                            @Override
                            public void onSuccess(Uri uri) {

                                myurl = uri.toString();
                            }
                        }).addOnCompleteListener(new OnCompleteListener() {
                            @Override
                            public void onComplete(@NonNull Task task) {

                                if (task.isSuccessful()) {
                                    Map messagebody = new HashMap();
                                    messagebody.put("message", myurl);
                                    messagebody.put("name", imageuri.getLastPathSegment());
                                    messagebody.put("time", CurrentTime);
                                    messagebody.put("date", CurrentDate);
                                    messagebody.put("type", checker);
                                    messagebody.put("from", Senderid);
                                    messagebody.put("to", recieverid);
                                    messagebody.put("messageid", messagepushid);

                                    Map messagedetail = new HashMap();
                                    messagedetail.put(messagesenderref + "/" + messagepushid, messagebody);
                                    messagedetail.put(messagerecieverref + "/" + messagepushid, messagebody);

                                    chatref.updateChildren(messagedetail).addOnCompleteListener(new OnCompleteListener() {
                                        @Override
                                        public void onComplete(@NonNull Task task) {
                                            if (task.isSuccessful()) {
                                                progressDialog.dismiss();
                                                Toast.makeText(ChatActivity.this, "Sent", Toast.LENGTH_SHORT).show();
                                                inputmessage.setText(null);
                                            } else {
                                                progressDialog.dismiss();
                                                Toast.makeText(ChatActivity.this, task.getException().toString(), Toast.LENGTH_SHORT).show();
                                                inputmessage.setText(null);
                                            }
                                        }
                                    });
                                }

                            }
                        });


                    }
                });
            } else {
                progressDialog.dismiss();

            }

        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        userref.child(recieverid).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists())
                {
                    String image = (String) dataSnapshot.child("ProfileImage").getValue();
                    String Name = (String) dataSnapshot.child("Name").getValue();

                    name.setText(Name);
                    Glide.with(ChatActivity.this).load(image).into(profileimage);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}