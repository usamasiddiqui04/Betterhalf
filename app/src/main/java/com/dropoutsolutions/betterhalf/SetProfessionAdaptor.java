package com.dropoutsolutions.betterhalf;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.dropoutsolutions.betterhalf.Fragment.Gender;
import com.dropoutsolutions.betterhalf.Fragment.ProfileFragment;
import com.dropoutsolutions.betterhalf.GetString;
import com.dropoutsolutions.betterhalf.ProfilesettingActivity;
import com.dropoutsolutions.betterhalf.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;

public class SetProfessionAdaptor extends RecyclerView.Adapter<SetProfessionAdaptor.MyViewHolder> {
    private ArrayList<String> text = new ArrayList<>();
    private Context context ;
    private int row_index ;
    private FirebaseAuth mauth ;
    private DatabaseReference userref ;
    private String Currentuserid ;

    public SetProfessionAdaptor(ArrayList<String> text, Context context) {
        this.text = text;
        this.context = context;
    }

    @NonNull
    @Override
    public SetProfessionAdaptor.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.professionrecylerlayout, parent, false);

        return new MyViewHolder(itemView);
    }
    @Override
    public void onBindViewHolder(@NonNull final SetProfessionAdaptor.MyViewHolder holder, final int position) {



        holder.item.setText(text.get(position));
        holder.item.setOnClickListener(v -> {

            row_index = position;
            notifyDataSetChanged();
            if (row_index == position)
            {
                savedata(text.get(row_index));
                context.startActivity(new Intent(context , ProfilesettingActivity.class));
            }
        });

        if (row_index == 0)
        {
            holder.item.setBackgroundResource(R.drawable.resetbackground);
        }

        else if (row_index == position)
        {
            holder.item.setBackgroundResource(R.drawable.edittextback);
            holder.item.setPadding(20,10,20,10);

        }
        else
        {
            holder.item.setBackgroundResource(R.drawable.resetbackground);
        }

    }

    private void savedata(String s) {
        mauth = FirebaseAuth.getInstance() ;
        Currentuserid = mauth.getCurrentUser().getUid();
        userref = FirebaseDatabase.getInstance().getReference().child("Users").child(Currentuserid);
        HashMap<String, Object> user = new HashMap<>();
        user.put("Profession" , s);
        userref.updateChildren(user).addOnCompleteListener(task -> {
            if (task.isSuccessful())
            {
                Toast.makeText(context, "Profession done", Toast.LENGTH_SHORT).show();
            }

        });


    }


    @Override
    public int getItemCount() {
        return text.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView item ;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            item = itemView.findViewById(R.id.profession);
        }
    }
}
