# RecyclerView to pass Item ClickListner To Fragment with passing parameters

In this program recycleview list is show on which item clickListner is used to send the clicklistner of adapter to the fragment.

```kotlin
adapter.onItemClick = { contact, status ->
        // do something with your item
        Log.d("TAG", contact.email)
    }
    
    
    ## Screenshot
    ![Alt text](https://github.com/abdulqadirtr/Kotlin_Retrofit_RecyclerView/blob/master/app/src/main/res/drawable-v24/screenshot.png)

