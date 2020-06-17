package com.dropoutsolutions.betterhalf;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.makeramen.roundedimageview.RoundedImageView;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class MessageAdapter  extends RecyclerView.Adapter<MessageAdapter.MessageViewHolder> {


    private List<Messages> usermessagelist ;
    private FirebaseAuth auth ;
    private Context context ;

    public MessageAdapter(List<Messages> usermessagelist, Context context) {
        this.usermessagelist = usermessagelist;
        this.context = context;
    }

    @NonNull
    @Override
    public MessageViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.messagelayout , viewGroup , false);

        auth = FirebaseAuth.getInstance() ;
        return new MessageViewHolder(view) ;

    }

    @Override
    public void onBindViewHolder(@NonNull final MessageViewHolder holder, final int i) {
        String messageSenderId = auth.getCurrentUser().getUid();
        Messages messages = usermessagelist.get(i);



        String Fromuserid = messages.getFrom();
        String frommessagetype = messages.getType() ;

        holder.recieverImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context , OnclickDetails.class);
                intent.putExtra("Userid" , Fromuserid);
                context.startActivity(intent);
            }
        });

        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference().child("Users").child(Fromuserid);
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if (dataSnapshot.exists())
                {
                    String Image = dataSnapshot.child("ProfileImage").getValue().toString() ;
                    Picasso.get().load(Image).into(holder.recieverImage);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        holder.reciever.setVisibility(View.GONE);
        holder.recieverImage.setVisibility(View.GONE);
        holder.sender.setVisibility(View.GONE);
        holder.senderimage.setVisibility(View.GONE);
        holder.reciverimage.setVisibility(View.GONE);

        if (frommessagetype.equals("text"))
        {
            if (Fromuserid.equals(messageSenderId))
            {
                holder.sender.setVisibility(View.VISIBLE);
                holder.sender.setBackgroundResource(R.drawable.sendermessagelayout);
                holder.sender.setGravity(Gravity.LEFT);
                holder.sender.setText(messages.getMessage() + "\n\n" + messages.getTime() + "-" + messages.getDate());

            }

            else
            {

                holder.reciever.setVisibility(View.VISIBLE);
                holder.recieverImage.setVisibility(View.VISIBLE);
                holder.reciever.setBackgroundResource(R.drawable.recievermessagelayout);
                holder.reciever.setGravity(Gravity.LEFT);
                holder.reciever.setText(messages.getMessage() + "\n\n" + messages.getTime() + "-" + messages.getDate());

            }
        }
        else if (frommessagetype.equals("image"))
        {
            if (Fromuserid.equals(messageSenderId))
            {
                holder.senderimage.setVisibility(View.VISIBLE);
                Picasso.get().load(messages.getMessage()).into(holder.senderimage);
            }
            else
            {
                holder.reciverimage.setVisibility(View.VISIBLE);
                holder.recieverImage.setVisibility(View.VISIBLE);
                Picasso.get().load(messages.getMessage()).into(holder.reciverimage);
            }
        }
        else
        {
            if(Fromuserid.equals(messageSenderId))
            {
                holder.senderimage.setVisibility(View.VISIBLE);
                holder.senderimage.setBackgroundResource(R.drawable.ic_pdf);
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(Intent.ACTION_VIEW , Uri.parse(usermessagelist.get(i).getMessage()));
                        holder.itemView.getContext().startActivity(intent);

                    }
                });

            }
            else
            {
                holder.recieverImage.setVisibility(View.VISIBLE);
                holder.reciverimage.setVisibility(View.VISIBLE);
                holder.reciverimage.setBackgroundResource(R.drawable.ic_pdf);

                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(Intent.ACTION_VIEW , Uri.parse(usermessagelist.get(i).getMessage()));
                        holder.itemView.getContext().startActivity(intent);

                    }
                });

            }
        }


    }

    @Override
    public int getItemCount() {
        return usermessagelist.size();
    }

    public class MessageViewHolder extends RecyclerView.ViewHolder {

        public TextView sender , reciever ;
        public CircleImageView recieverImage ;
        RoundedImageView senderimage , reciverimage ;

        public MessageViewHolder(@NonNull View itemView) {
            super(itemView);

            sender = itemView.findViewById(R.id.sendermessage);
            reciever = itemView.findViewById(R.id.recievermessage);
            recieverImage = itemView.findViewById(R.id.recieverimage);
            senderimage = itemView.findViewById(R.id.sender_imageview);
            reciverimage = itemView.findViewById(R.id.recievr_imageview);

        }
    }
}
