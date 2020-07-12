package com.dropoutsolutions.betterhalf;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class EthnicoriginActivity extends AppCompatActivity {
    TextView pakistani , afgani ,indian ,arab ,bangladeshi ,africian ,caucasian ,fareast ,persina ,turkish ;
    FirebaseAuth firebaseAuth ;
    DatabaseReference userref ;
    String id ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ethnicorigin);

        firebaseAuth = firebaseAuth.getInstance();
        id = firebaseAuth.getCurrentUser().getUid();
        userref = FirebaseDatabase.getInstance().getReference().child("Users").child(id);

        pakistani = findViewById(R.id.Pakistani);
        afgani = findViewById(R.id.afgani);
        indian =  findViewById(R.id.indian);
        arab = findViewById(R.id.arab);
        bangladeshi = findViewById(R.id.bangali);
        africian = findViewById(R.id.african);
        caucasian = findViewById(R.id.white);
        fareast = findViewById(R.id.fareast);
        persina = findViewById(R.id.percian);
        turkish = findViewById(R.id.turkish);


        pakistani.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pakistani.setPadding(20, 10, 20, 10);
                pakistani.setBackgroundResource(R.drawable.edittextback);
                afgani.setBackgroundResource(R.drawable.resetbackground);
                indian.setBackgroundResource(R.drawable.resetbackground);
                arab.setBackgroundResource(R.drawable.resetbackground);
                bangladeshi.setBackgroundResource(R.drawable.resetbackground);
                africian.setBackgroundResource(R.drawable.resetbackground);
                caucasian.setBackgroundResource(R.drawable.resetbackground);
                fareast.setBackgroundResource(R.drawable.resetbackground);
                persina.setBackgroundResource(R.drawable.resetbackground);
                turkish.setBackgroundResource(R.drawable.resetbackground);

                HashMap<String, Object> user = new HashMap<>();
                user.put("Origin" , pakistani.getText());
                userref.updateChildren(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful())
                        {
                            startActivity(new Intent (EthnicoriginActivity.this , ProfilesettingActivity.class));
                            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                            finish();
                        }
                    }
                });
            }
        });

        afgani.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                afgani.setPadding(20, 10, 20, 10);
                afgani.setBackgroundResource(R.drawable.edittextback);
                pakistani.setBackgroundResource(R.drawable.resetbackground);
                indian.setBackgroundResource(R.drawable.resetbackground);
                arab.setBackgroundResource(R.drawable.resetbackground);
                bangladeshi.setBackgroundResource(R.drawable.resetbackground);
                africian.setBackgroundResource(R.drawable.resetbackground);
                caucasian.setBackgroundResource(R.drawable.resetbackground);
                fareast.setBackgroundResource(R.drawable.resetbackground);
                persina.setBackgroundResource(R.drawable.resetbackground);
                turkish.setBackgroundResource(R.drawable.resetbackground);

                HashMap<String, Object> user = new HashMap<>();
                user.put("Origin" , afgani.getText());
                userref.updateChildren(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful())
                        {
                            startActivity(new Intent (EthnicoriginActivity.this , ProfilesettingActivity.class));
                            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                            finish();
                        }
                    }
                });
            }
        });

        indian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                indian.setPadding(20, 10, 20, 10);
                indian.setBackgroundResource(R.drawable.edittextback);
                pakistani.setBackgroundResource(R.drawable.resetbackground);
                afgani.setBackgroundResource(R.drawable.resetbackground);
                arab.setBackgroundResource(R.drawable.resetbackground);
                bangladeshi.setBackgroundResource(R.drawable.resetbackground);
                africian.setBackgroundResource(R.drawable.resetbackground);
                caucasian.setBackgroundResource(R.drawable.resetbackground);
                fareast.setBackgroundResource(R.drawable.resetbackground);
                persina.setBackgroundResource(R.drawable.resetbackground);
                turkish.setBackgroundResource(R.drawable.resetbackground);

                HashMap<String, Object> user = new HashMap<>();
                user.put("Origin" , indian.getText());
                userref.updateChildren(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful())
                        {
                            startActivity(new Intent (EthnicoriginActivity.this , ProfilesettingActivity.class));
                            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                            finish();
                        }
                    }
                });
            }
        });


        arab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arab.setPadding(20, 10, 20, 10);
                arab.setBackgroundResource(R.drawable.edittextback);
                pakistani.setBackgroundResource(R.drawable.resetbackground);
                afgani.setBackgroundResource(R.drawable.resetbackground);
                indian.setBackgroundResource(R.drawable.resetbackground);
                bangladeshi.setBackgroundResource(R.drawable.resetbackground);
                africian.setBackgroundResource(R.drawable.resetbackground);
                caucasian.setBackgroundResource(R.drawable.resetbackground);
                fareast.setBackgroundResource(R.drawable.resetbackground);
                persina.setBackgroundResource(R.drawable.resetbackground);
                turkish.setBackgroundResource(R.drawable.resetbackground);

                HashMap<String, Object> user = new HashMap<>();
                user.put("Origin" , arab.getText());
                userref.updateChildren(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful())
                        {
                            startActivity(new Intent (EthnicoriginActivity.this , ProfilesettingActivity.class));
                            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                            finish();
                        }
                    }
                });
            }
        });
        bangladeshi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bangladeshi.setPadding(20, 10, 20, 10);
                bangladeshi.setBackgroundResource(R.drawable.edittextback);
                pakistani.setBackgroundResource(R.drawable.resetbackground);
                afgani.setBackgroundResource(R.drawable.resetbackground);
                indian.setBackgroundResource(R.drawable.resetbackground);
                arab.setBackgroundResource(R.drawable.resetbackground);
                africian.setBackgroundResource(R.drawable.resetbackground);
                caucasian.setBackgroundResource(R.drawable.resetbackground);
                fareast.setBackgroundResource(R.drawable.resetbackground);
                persina.setBackgroundResource(R.drawable.resetbackground);
                turkish.setBackgroundResource(R.drawable.resetbackground);

                HashMap<String, Object> user = new HashMap<>();
                user.put("Origin" , bangladeshi.getText());
                userref.updateChildren(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful())
                        {
                            startActivity(new Intent (EthnicoriginActivity.this , ProfilesettingActivity.class));
                            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                            finish();
                        }
                    }
                });
            }
        });

        africian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                africian.setPadding(20, 10, 20, 10);
                africian.setBackgroundResource(R.drawable.edittextback);
                pakistani.setBackgroundResource(R.drawable.resetbackground);
                afgani.setBackgroundResource(R.drawable.resetbackground);
                indian.setBackgroundResource(R.drawable.resetbackground);
                arab.setBackgroundResource(R.drawable.resetbackground);
                bangladeshi.setBackgroundResource(R.drawable.resetbackground);
                caucasian.setBackgroundResource(R.drawable.resetbackground);
                fareast.setBackgroundResource(R.drawable.resetbackground);
                persina.setBackgroundResource(R.drawable.resetbackground);
                turkish.setBackgroundResource(R.drawable.resetbackground);

                HashMap<String, Object> user = new HashMap<>();
                user.put("Origin" , africian.getText());
                userref.updateChildren(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful())
                        {
                            startActivity(new Intent (EthnicoriginActivity.this , ProfilesettingActivity.class));
                            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                            finish();
                        }
                    }
                });
            }
        });

        caucasian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                caucasian.setPadding(20, 10, 20, 10);
                caucasian.setBackgroundResource(R.drawable.edittextback);
                pakistani.setBackgroundResource(R.drawable.resetbackground);
                afgani.setBackgroundResource(R.drawable.resetbackground);
                indian.setBackgroundResource(R.drawable.resetbackground);
                arab.setBackgroundResource(R.drawable.resetbackground);
                bangladeshi.setBackgroundResource(R.drawable.resetbackground);
                africian.setBackgroundResource(R.drawable.resetbackground);
                fareast.setBackgroundResource(R.drawable.resetbackground);
                persina.setBackgroundResource(R.drawable.resetbackground);
                turkish.setBackgroundResource(R.drawable.resetbackground);

                HashMap<String, Object> user = new HashMap<>();
                user.put("Origin" ,caucasian.getText());
                userref.updateChildren(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful())
                        {
                            startActivity(new Intent (EthnicoriginActivity.this , ProfilesettingActivity.class));
                            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                            finish();
                        }
                    }
                });
            }
        });

        fareast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fareast.setPadding(20, 10, 20, 10);
                fareast.setBackgroundResource(R.drawable.edittextback);
                pakistani.setBackgroundResource(R.drawable.resetbackground);
                afgani.setBackgroundResource(R.drawable.resetbackground);
                indian.setBackgroundResource(R.drawable.resetbackground);
                arab.setBackgroundResource(R.drawable.resetbackground);
                bangladeshi.setBackgroundResource(R.drawable.resetbackground);
                africian.setBackgroundResource(R.drawable.resetbackground);
                caucasian.setBackgroundResource(R.drawable.resetbackground);
                persina.setBackgroundResource(R.drawable.resetbackground);
                turkish.setBackgroundResource(R.drawable.resetbackground);

                HashMap<String, Object> user = new HashMap<>();
                user.put("Origin" , fareast.getText());
                userref.updateChildren(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful())
                        {
                            startActivity(new Intent (EthnicoriginActivity.this , ProfilesettingActivity.class));
                            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                            finish();
                        }
                    }
                });
            }
        });


        persina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                persina.setPadding(20, 10, 20, 10);
                persina.setBackgroundResource(R.drawable.edittextback);
                pakistani.setBackgroundResource(R.drawable.resetbackground);
                afgani.setBackgroundResource(R.drawable.resetbackground);
                indian.setBackgroundResource(R.drawable.resetbackground);
                arab.setBackgroundResource(R.drawable.resetbackground);
                bangladeshi.setBackgroundResource(R.drawable.resetbackground);
                africian.setBackgroundResource(R.drawable.resetbackground);
                caucasian.setBackgroundResource(R.drawable.resetbackground);
                fareast.setBackgroundResource(R.drawable.resetbackground);
                turkish.setBackgroundResource(R.drawable.resetbackground);

                HashMap<String, Object> user = new HashMap<>();
                user.put("Origin" , persina.getText());
                userref.updateChildren(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful())
                        {
                            startActivity(new Intent (EthnicoriginActivity.this , ProfilesettingActivity.class));
                            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                            finish();
                        }
                    }
                });
            }
        });

        turkish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                turkish.setPadding(20, 10, 20, 10);
                turkish.setBackgroundResource(R.drawable.edittextback);
                pakistani.setBackgroundResource(R.drawable.resetbackground);
                afgani.setBackgroundResource(R.drawable.resetbackground);
                indian.setBackgroundResource(R.drawable.resetbackground);
                arab.setBackgroundResource(R.drawable.resetbackground);
                bangladeshi.setBackgroundResource(R.drawable.resetbackground);
                africian.setBackgroundResource(R.drawable.resetbackground);
                caucasian.setBackgroundResource(R.drawable.resetbackground);
                fareast.setBackgroundResource(R.drawable.resetbackground);
                persina.setBackgroundResource(R.drawable.resetbackground);

                HashMap<String, Object> user = new HashMap<>();
                user.put("Origin" , turkish.getText());
                userref.updateChildren(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful())
                        {
                            startActivity(new Intent (EthnicoriginActivity.this , ProfilesettingActivity.class));
                            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                            finish();
                        }
                    }
                });
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        userref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists())
                {
                    if (snapshot.hasChild("Origin"))
                    {
                        String o = (String) snapshot.child("Origin").getValue();

                        if (o.equals(pakistani.getText()))
                        {
                            pakistani.setPadding(20, 10, 20, 10);
                            pakistani.setBackgroundResource(R.drawable.edittextback);
                            afgani.setBackgroundResource(R.drawable.resetbackground);
                            indian.setBackgroundResource(R.drawable.resetbackground);
                            arab.setBackgroundResource(R.drawable.resetbackground);
                            bangladeshi.setBackgroundResource(R.drawable.resetbackground);
                            africian.setBackgroundResource(R.drawable.resetbackground);
                            caucasian.setBackgroundResource(R.drawable.resetbackground);
                            fareast.setBackgroundResource(R.drawable.resetbackground);
                            persina.setBackgroundResource(R.drawable.resetbackground);
                            turkish.setBackgroundResource(R.drawable.resetbackground);

                        }
                        else if (o.equals(afgani.getText()))
                        {
                            afgani.setPadding(20, 10, 20, 10);
                            afgani.setBackgroundResource(R.drawable.edittextback);
                            pakistani.setBackgroundResource(R.drawable.resetbackground);
                            indian.setBackgroundResource(R.drawable.resetbackground);
                            arab.setBackgroundResource(R.drawable.resetbackground);
                            bangladeshi.setBackgroundResource(R.drawable.resetbackground);
                            africian.setBackgroundResource(R.drawable.resetbackground);
                            caucasian.setBackgroundResource(R.drawable.resetbackground);
                            fareast.setBackgroundResource(R.drawable.resetbackground);
                            persina.setBackgroundResource(R.drawable.resetbackground);
                            turkish.setBackgroundResource(R.drawable.resetbackground);
                        }
                        else if (o.equals(indian.getText()))
                        {
                            indian.setPadding(20, 10, 20, 10);
                            indian.setBackgroundResource(R.drawable.edittextback);
                            pakistani.setBackgroundResource(R.drawable.resetbackground);
                            afgani.setBackgroundResource(R.drawable.resetbackground);
                            arab.setBackgroundResource(R.drawable.resetbackground);
                            bangladeshi.setBackgroundResource(R.drawable.resetbackground);
                            africian.setBackgroundResource(R.drawable.resetbackground);
                            caucasian.setBackgroundResource(R.drawable.resetbackground);
                            fareast.setBackgroundResource(R.drawable.resetbackground);
                            persina.setBackgroundResource(R.drawable.resetbackground);
                            turkish.setBackgroundResource(R.drawable.resetbackground);
                        }
                        else if (o.equals(arab.getText()))
                        {
                            arab.setPadding(20, 10, 20, 10);
                            arab.setBackgroundResource(R.drawable.edittextback);
                            pakistani.setBackgroundResource(R.drawable.resetbackground);
                            afgani.setBackgroundResource(R.drawable.resetbackground);
                            indian.setBackgroundResource(R.drawable.resetbackground);
                            bangladeshi.setBackgroundResource(R.drawable.resetbackground);
                            africian.setBackgroundResource(R.drawable.resetbackground);
                            caucasian.setBackgroundResource(R.drawable.resetbackground);
                            fareast.setBackgroundResource(R.drawable.resetbackground);
                            persina.setBackgroundResource(R.drawable.resetbackground);
                            turkish.setBackgroundResource(R.drawable.resetbackground);
                        }
                        else if (o.equals(bangladeshi.getText()))
                        {
                            bangladeshi.setPadding(20, 10, 20, 10);
                            bangladeshi.setBackgroundResource(R.drawable.edittextback);
                            pakistani.setBackgroundResource(R.drawable.resetbackground);
                            afgani.setBackgroundResource(R.drawable.resetbackground);
                            indian.setBackgroundResource(R.drawable.resetbackground);
                            arab.setBackgroundResource(R.drawable.resetbackground);
                            africian.setBackgroundResource(R.drawable.resetbackground);
                            caucasian.setBackgroundResource(R.drawable.resetbackground);
                            fareast.setBackgroundResource(R.drawable.resetbackground);
                            persina.setBackgroundResource(R.drawable.resetbackground);
                            turkish.setBackgroundResource(R.drawable.resetbackground);
                        }
                        else if (o.equals(africian.getText()))
                        {
                            africian.setPadding(20, 10, 20, 10);
                            africian.setBackgroundResource(R.drawable.edittextback);
                            pakistani.setBackgroundResource(R.drawable.resetbackground);
                            afgani.setBackgroundResource(R.drawable.resetbackground);
                            indian.setBackgroundResource(R.drawable.resetbackground);
                            arab.setBackgroundResource(R.drawable.resetbackground);
                            bangladeshi.setBackgroundResource(R.drawable.resetbackground);
                            caucasian.setBackgroundResource(R.drawable.resetbackground);
                            fareast.setBackgroundResource(R.drawable.resetbackground);
                            persina.setBackgroundResource(R.drawable.resetbackground);
                            turkish.setBackgroundResource(R.drawable.resetbackground);
                        }
                        else if (o.equals(caucasian.getText()))
                        {
                            caucasian.setPadding(20, 10, 20, 10);
                            caucasian.setBackgroundResource(R.drawable.edittextback);
                            pakistani.setBackgroundResource(R.drawable.resetbackground);
                            afgani.setBackgroundResource(R.drawable.resetbackground);
                            indian.setBackgroundResource(R.drawable.resetbackground);
                            arab.setBackgroundResource(R.drawable.resetbackground);
                            bangladeshi.setBackgroundResource(R.drawable.resetbackground);
                            africian.setBackgroundResource(R.drawable.resetbackground);
                            fareast.setBackgroundResource(R.drawable.resetbackground);
                            persina.setBackgroundResource(R.drawable.resetbackground);
                            turkish.setBackgroundResource(R.drawable.resetbackground);

                        }
                        else if (o.equals(fareast.getText()))
                        {
                            fareast.setPadding(20, 10, 20, 10);
                            fareast.setBackgroundResource(R.drawable.edittextback);
                            pakistani.setBackgroundResource(R.drawable.resetbackground);
                            afgani.setBackgroundResource(R.drawable.resetbackground);
                            indian.setBackgroundResource(R.drawable.resetbackground);
                            arab.setBackgroundResource(R.drawable.resetbackground);
                            bangladeshi.setBackgroundResource(R.drawable.resetbackground);
                            africian.setBackgroundResource(R.drawable.resetbackground);
                            caucasian.setBackgroundResource(R.drawable.resetbackground);
                            persina.setBackgroundResource(R.drawable.resetbackground);
                            turkish.setBackgroundResource(R.drawable.resetbackground);

                        }

                        else if (o.equals(turkish.getText()))
                        {
                            turkish.setPadding(20, 10, 20, 10);
                            turkish.setBackgroundResource(R.drawable.edittextback);
                            pakistani.setBackgroundResource(R.drawable.resetbackground);
                            afgani.setBackgroundResource(R.drawable.resetbackground);
                            indian.setBackgroundResource(R.drawable.resetbackground);
                            arab.setBackgroundResource(R.drawable.resetbackground);
                            bangladeshi.setBackgroundResource(R.drawable.resetbackground);
                            africian.setBackgroundResource(R.drawable.resetbackground);
                            caucasian.setBackgroundResource(R.drawable.resetbackground);
                            fareast.setBackgroundResource(R.drawable.resetbackground);
                            persina.setBackgroundResource(R.drawable.resetbackground);
                        }
                        else
                        {
                            persina.setPadding(20, 10, 20, 10);
                            persina.setBackgroundResource(R.drawable.edittextback);
                            pakistani.setBackgroundResource(R.drawable.resetbackground);
                            afgani.setBackgroundResource(R.drawable.resetbackground);
                            indian.setBackgroundResource(R.drawable.resetbackground);
                            arab.setBackgroundResource(R.drawable.resetbackground);
                            bangladeshi.setBackgroundResource(R.drawable.resetbackground);
                            africian.setBackgroundResource(R.drawable.resetbackground);
                            caucasian.setBackgroundResource(R.drawable.resetbackground);
                            fareast.setBackgroundResource(R.drawable.resetbackground);
                            turkish.setBackgroundResource(R.drawable.resetbackground);
                        }

                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(this , ProfilesettingActivity.class));
        finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }
}