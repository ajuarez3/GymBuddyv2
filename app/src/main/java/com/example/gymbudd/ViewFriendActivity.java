//package com.example.gymbudd;

//import androidx.annotation.NonNull;
//import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//import android.widget.TextView;
//import android.widget.Toast;

//import com.google.android.gms.tasks.OnCompleteListener;
//import com.google.android.gms.tasks.Task;
//import com.google.firebase.auth.FirebaseAuth;
//import com.google.firebase.database.DataSnapshot;
//import com.google.firebase.database.DatabaseError;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;
//import com.google.firebase.database.ValueEventListener;
//import com.google.firebase.firestore.FirebaseFirestore;
//import com.google.firebase.storage.FirebaseStorage;
import com.google.protobuf.Value;

//import java.util.HashMap;

//import de.hdodenhof.circleimageview.CircleImageView;

//public class ViewFriendActivity extends AppCompatActivity {
  //  DatabaseReference mUserRef, requestRef, friendRef;
    //FirebaseAuth mAuth;
    //FirebaseAuth mUser;
    //String profileImageURL, username, city, country;

    //FirebaseStorage storage = FirebaseStorage.getInstance();
    //FirebaseAuth auth = FirebaseAuth.getInstance();
    //FirebaseFirestore dataStore = FirebaseFirestore.getInstance();

    //CircleImageView profileImage;
    //TextView Username, address;
    //Button btnPerform, btnDecline;
    //String CurrentState="Nothing_happened";

    //@Override
    //protected void onCreate(Bundle savedInstanceState) {
      //  super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_view_friend);
        //final String userID=getIntent().getStringExtra("userKey");

        //mUserRef = FirebaseDatabase.getInstance().getReference().child("Users").child(userID);
        //requestRef = FirebaseDatabase.getInstance().getReference().child("Requests");
        //friendRef = FirebaseDatabase.getInstance().getReference().child("Friends");

        //mAuth=FirebaseAuth.getInstance();

        //btnPerform=findViewById(R.id.btnPerform);
        //btnDecline=findViewById(R.id.btnDecline);

        //Username=findViewById(R.id.username);

        //btnPerform.setOnClickListener(new View.OnClickListener() {
          //  @Override
            //public void onClick(View v) {
              //  PerformAction(userID);
           // }
        //});
        //CheckUserExistance(userID);
        //btnDecline.setOnClickListener(new View.OnClickListener() {
          //  @Override
            //public void onClick(View v) {
              //  Unfriend(userID);
            //}
        //});
    //}
    //private void Unfriend(String userID) {
      //  if(CurrentState.equals("friend"))
       // {
         //   friendRef.child(mUser.getUid()).child(userID).removeValue().addOnCompleteListener(new OnCompleteListener<Void>() {
           //     @Override
             //   public void onComplete(@NonNull Task<Void> task) {
               //     if (task.isSuccessful())
                 //   {
                   //     friendRef.child(userID).child(mUser.getUid()).removeValue().addOnCompleteListener(new OnCompleteListener<Void>() {
                     //       @Override
                         //   public void onComplete(@NonNull Task<Void> task) {
                       //         if (task.isSuccessful())
                           //     {
                             //       Toast.makeText(ViewFriendActivity.this, "You are unfriended", Toast.LENGTH_SHORT).show();
                               //     CurrentState="Nothing happened";
                                 //   btnPerform.setText("Send Friend Request");
                                   // btnDecline.setVisibility(View.GONE);
                                //}
                            //}
                        //});
                    //}
                //}
            //});
            //if(CurrentState.equals("pending request"))
            //{
              //  HashMap hashMap= new HashMap();
                //hashMap.put("status", "decline");
                //requestRef.child(userID).child(mUser.getUid()).updateChildren(hashMap).addOnCompleteListener(new OnCompleteListener() {
    //                @Override
      //              public void onComplete(@NonNull Task task) {
        //                if (task.isSuccessful())
          //              {
            //                Toast.makeText(ViewFriendActivity.this, "You have declined Friend", Toast.LENGTH_SHORT).show();
              //              CurrentState="declined request";
                //            btnPerform.setVisibility(View.GONE);
                  //          btnDecline.setVisibility(View.GONE);
                   //     }
  //                  }
    //            });
      //      }
        //}

    //}
    //private void CheckUserExistance(String userID) {
      //  friendRef.child(mUser.getUid()).child(userID).addValueEventListener(new ValueEventListener() {
        //                                                                        @Override
          //                                                                      public void onDataChange(@NonNull DataSnapshot snapshot) {
            //                                                                        if (snapshot.exists())
              //                                                                      {
                //                                                                        CurrentState="friend";
                  //                                                                      btnPerform.setText("Send Message");
                    //                                                                    btnDecline.setText("Unfriend");
                      //                                                                  btnDecline.setVisibility(View.VISIBLE);
                        //                                                            }
                          //                                                      }
                            //                                                    @Override
                              //                                                  public void onCancelled(@NonNull DatabaseError error) {
                                //                                                }
                                  //                                          }
        //);
        //friendRef.child(userID).child(mUser.getUid()).addValueEventListener(new ValueEventListener() {
          //  @Override
            //public void onDataChange(@NonNull DataSnapshot snapshot) {
              //  if (snapshot.exists())
                //{
                  //  CurrentState="friend";
                    //btnPerform.setText("Send Message");
                    //btnDecline.setText("Unfriend");
                    //btnDecline.setVisibility(View.VISIBLE);
    //            }
      //      }

//            @Override
  //          public void onCancelled(@NonNull DatabaseError error) {

    //        }
      //  });
        //requestRef.child(mUser.getUid()).child(userID).addValueEventListener(new ValueEventListener() {
          //  @Override
    //        public void onDataChange(@NonNull DataSnapshot snapshot) {
      //          if(snapshot.exists())
        //        {
          //          if (snapshot.child("status").getValue().toString().equals("pending")){
            //            CurrentState="I sent pending";
              //          btnPerform.setText("Cancel Friend Request");
                //        btnDecline.setVisibility(View.GONE);

                  //  }
                    //if (snapshot.child("status").getValue().toString().equals("decline")){
                //        CurrentState="I sent decline";
                  //      btnPerform.setText("Cancel Friend Request");
                    //    btnDecline.setVisibility(View.GONE);

                   // }
                //}
            //}

     //       @Override
   //         public void onCancelled(@NonNull DatabaseError error) {

       //     }
        //});
        //requestRef.child(userID).child(mUser.getUid()).addValueEventListener(new ValueEventListener() {
          //  @Override
            //public void onDataChange(@NonNull DataSnapshot snapshot) {
              //  if(snapshot.exists())
                //{
                  //  if (snapshot.child("status").getValue().toString().equals("pending"))
                    //{
                      //  CurrentState="sent pending request";
                        //btnPerform.setText("Accept Friend Request");
                        //btnDecline.setText("Decline Friend Request");
                        //btnDecline.setVisibility(View.VISIBLE);

                    //}

                //}
            //}

    //        @Override
      //      public void onCancelled(@NonNull DatabaseError error) {
//
  //          }
    //    });
      //  if (CurrentState.equals("nothing happened"))
        //{
          //  CurrentState="nothing happened";
            //btnPerform.setText("Send Friend Request");
            //btnDecline.setVisibility(View.GONE);
       // }
   // }

   // private void PerformAction(String userID){
     //   if (CurrentState.equals("Nothing_happened"))
       // {
 //           HashMap hashMap=new HashMap();
//            hashMap.put("status", "pending");
//            requestRef.child(mUser.getUid()).child(userID).updateChildren(hashMap).addOnCompleteListener(new OnCompleteListener() {
  //              @Override
   //             public void onComplete(@NonNull Task task) {
     //               if(task.isSuccessful())
       //             {
         //               Toast.makeText(ViewFriendActivity.this, "You have sent a friend request", Toast.LENGTH_SHORT).show();

           //             btnDecline.setVisibility(View.GONE);
             //           CurrentState= "I sent pending";
               //         btnPerform.setText("Cancel Friend Request");
                 //   }
                   // else
 //                   {
   //                     Toast.makeText(ViewFriendActivity.this, ""+ task.getException().toString(), Toast.LENGTH_SHORT).show();
     //               }
       //         }
         //   });
       // }
  //      if (CurrentState.equals("I sent pending") || CurrentState.equals("I sent decline"))
    //    {
      //      requestRef.child(mUser.getUid()).child(userID).removeValue().addOnCompleteListener(new OnCompleteListener<Void>() {

//                @Override
  //              public void onComplete(@NonNull Task<Void> task) {
    //                if (task.isSuccessful())
      //              {
        //                Toast.makeText(ViewFriendActivity.this, "You have cancelled a friend request", Toast.LENGTH_SHORT).show();
   //                     CurrentState="nothing happened";
     //                   btnPerform.setText("Send Friend Request");
       //                 btnDecline.setVisibility(View.GONE);
         //           }
           //         else {
             //           Toast.makeText(ViewFriendActivity.this, ""+ task.getException().toString(), Toast.LENGTH_SHORT).show();

               //     }
  //              }
    //        });
      //  }
        //if(CurrentState.equals("pending request"))
       // {
         //   requestRef.child(mUser.getUid()).child(mUser.getUid()).removeValue().addOnCompleteListener(new OnCompleteListener<Void>() {

           //     @Override
             //   public void onComplete(@NonNull Task<Void> task) {
               //     if (task.isSuccessful())
                 //   {
                   //     HashMap hashMap = new HashMap();
                     //   hashMap.put("status", "friend");
                       // hashMap.put("username", username);
 //                       hashMap.put("profileimageURL", profileImageURL);
   //                     friendRef.child(mUser.getUid()).child(userID).updateChildren(hashMap).addOnCompleteListener(new OnCompleteListener() {
     //                       @Override
       //                     public void onComplete(@NonNull Task task) {
         //                       if (task.isSuccessful())
           //                     {
             //                       friendRef.child(userID).child(mUser.getUid()).updateChildren(hashMap).addOnCompleteListener(new OnCompleteListener() {
               //                         @Override
                 //                       public void onComplete(@NonNull Task task) {
                   //                         Toast.makeText(ViewFriendActivity.this, "You have added a friend", Toast.LENGTH_SHORT).show();
                     //                      CurrentState="friend";
                      //                      btnPerform.setText("Send texts");
                        //                    btnDecline.setText("Unfriend");
                          //                  btnDecline.setVisibility(View.VISIBLE);
//
  //                                      }
    //                                });
      //                          }
//
  //                          }
    //                    });
      //              }
        //        }
          //  });
  //      }
    //    if (CurrentState.equals("friend"))
      //  {

        //}
    //}
//}