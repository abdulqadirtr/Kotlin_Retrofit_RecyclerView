# RecyclerView to pass Item ClickListner To Fragment with passing parameters

In this android app API's data is received using Retrofit with complete MVVM architect and showed in recycleview
also item clickListner is used to send the clicklistner of adapter to the fragment.

## Technologies
* MVVM
* LiveData, Lifecycle Observer
* Retrofit
* ViewModel
* ViewModelFactory

```kotlin
adapter.onItemClick = { contact, status ->
        // do something with your item
        Log.d("TAG", contact.email)
    }
    
    
    ## Screenshot
    ![picture alt](http://via.placeholder.com/200x150 "Title is optional")
    ![Alt text](app/src/main/res/drawable-v24/screenshot.png)
 

