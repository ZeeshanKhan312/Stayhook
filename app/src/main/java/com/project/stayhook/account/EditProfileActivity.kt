package com.project.stayhook.account

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.project.stayhook.R
import com.project.stayhook.dashboard.DashboardActivity
import de.hdodenhof.circleimageview.CircleImageView

class EditProfileActivity : AppCompatActivity() {
    private lateinit var profileImage:CircleImageView
    private lateinit var backBtn:TextView
    private lateinit var userName:EditText
    private lateinit var email:EditText
    private lateinit var location:EditText
    private lateinit var phoneNo:EditText
    private lateinit var submitBtn:TextView

    private val PICK_IMAGE = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)

        initViews()

        backBtn.setOnClickListener {
            finish()
        }

        profileImage.setOnClickListener{
            val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            startActivityForResult(intent, PICK_IMAGE)
        }
        submitBtn.setOnClickListener {
            Toast.makeText(this, "Successfully Updated!!", Toast.LENGTH_SHORT).show()
            finish()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == PICK_IMAGE && resultCode == Activity.RESULT_OK && data != null) {
            val selectedImageUri = data.data
            // Set the selected image to the ImageView
            profileImage.setImageURI(selectedImageUri)
        }
    }

    fun initViews(){
        profileImage=findViewById(R.id.profileImage)
        backBtn=findViewById(R.id.backBtn)
        userName=findViewById(R.id.userName)
        email=findViewById(R.id.email)
        location=findViewById(R.id.location)
        phoneNo=findViewById(R.id.phoneNo)
        submitBtn=findViewById(R.id.submitBtn)
    }
}