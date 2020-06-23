package com.dropoutsolutions.betterhalf;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FacebookAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

import java.util.Arrays;

public class GoogleFacebookLogin extends AppCompatActivity {

    private static final int RC_SIGN_IN = 123;
    SignInButton google ;
    FirebaseAuth mauth ;
    private GoogleSignInClient mGoogleSignInClient;
    LoginButton loginButton ;
    CallbackManager callbackManager ;
    private static final String EMAIL = "email";
    ProgressDialog progressDialog ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.google_facebook_login);

        google = findViewById(R.id.google);
        mauth = FirebaseAuth.getInstance() ;
        loginButton = findViewById(R.id.facebook);
        progressDialog = new ProgressDialog(this);
        FacebookSdk.sdkInitialize(getApplicationContext());
        loginButton.setReadPermissions(Arrays.asList(EMAIL));
        createrequest();
        callbackManager = CallbackManager.Factory.create();


        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                handleFacebookToken(loginResult.getAccessToken());
            }

            @Override
            public void onCancel() {
                // App code
            }

            @Override
            public void onError(FacebookException exception) {
                // App code
            }
        });






        google.setOnClickListener(v -> signIn());

    }

    private void handleFacebookToken(AccessToken accessToken) {
        progressDialog.setTitle("Logging with facebook");
        progressDialog.setMessage("please wait");
        progressDialog.setCancelable(false);
        progressDialog.show();
        AuthCredential credential = FacebookAuthProvider.getCredential(accessToken.getToken());
        mauth.signInWithCredential(credential).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    // Sign in success, update UI with the signed-in user's information

                    FirebaseUser user = mauth.getCurrentUser();
                    Intent intent = new Intent(GoogleFacebookLogin.this , HomeActivity.class );
                    startActivity(intent);
                    finish();
                    progressDialog.dismiss();

                } else {
                    // If sign in fails, display a message to the user.
                    Toast.makeText(GoogleFacebookLogin.this, "Failed", Toast.LENGTH_SHORT).show();
                    progressDialog.dismiss();


                }
            }
        });


    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                // Google Sign In was successful, authenticate with Firebase
                GoogleSignInAccount account = task.getResult(ApiException.class);
                firebaseAuthWithGoogle(account);
            } catch (ApiException e) {
                // Google Sign In failed, update UI appropriately

                // ...
            }
        }
    }


    private void createrequest() {
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

    }

    private void GoToNickNameActivity() {
        Intent intent = new Intent(GoogleFacebookLogin.this , Continue.class );
        startActivity(intent);
        finish();
    }

    private void signIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    private void firebaseAuthWithGoogle(GoogleSignInAccount idToken) {
        progressDialog.setTitle("Logging with google");
        progressDialog.setMessage("please wait");
        progressDialog.setCancelable(false);
        progressDialog.show();
        AuthCredential credential = GoogleAuthProvider.getCredential(idToken.getIdToken(), null);
        mauth.signInWithCredential(credential)
                .addOnCompleteListener(this, task -> {

                    if (task.isSuccessful()) {
                        // Sign in success, update UI with the signed-in user's information
                        progressDialog.dismiss();
                        FirebaseUser user = mauth.getCurrentUser();
                        Toast.makeText(GoogleFacebookLogin.this, "Success", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(GoogleFacebookLogin.this , HomeActivity.class );
                        startActivity(intent);
                        finish();

                    } else {
                        // If sign in fails, display a message to the user.
                        Toast.makeText(GoogleFacebookLogin.this, "Failed", Toast.LENGTH_SHORT).show();
                        progressDialog.dismiss();


                    }

                });
    }



    @Override
    protected void onStart() {
        super.onStart();

        progressDialog.setTitle("checking internet connection");
        progressDialog.setCancelable(false);
        progressDialog.show();
        boolean connected = false;
        ConnectivityManager connectivityManager = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        if(connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {
            //we are connected to a network
            connected = true;
        }
        else
            connected = false;
        if (connected)
        {
            progressDialog.dismiss();
            FirebaseUser firebaseUser = mauth.getCurrentUser();
            if (firebaseUser!= null)
            {
                Intent intent = new Intent(GoogleFacebookLogin.this , HomeActivity.class );
                startActivity(intent);
            }
        }
        else
        {
            progressDialog.dismiss();
        }

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent a = new Intent(Intent.ACTION_MAIN);
        a.addCategory(Intent.CATEGORY_HOME);
        a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(a);
    }
}
