# [MagicalRequiredFields](https://github.com/fabian7593/MagicalRequiredFields)

An library easy-to-use of required fields in Android, this library validate the most important native Gui components of Android.

This library supports these components:<br>
* EditText<br>
* Spinner<br>
* RadioButton<br>
* CheckBox<br>
* Switch<br>
* ToggleButton<br>
* RatingBar<br>
* ImageView<br>
* SeekBar<br>
* ProgressBar<br>

<br><br>

## SDK
* It requires **14+ API**.
* The compile version is **API 23**.

<br><br>

## Getting Started

### Download Sources
use git (sourcetree or others)

```bash
git clone https://github.com/fabian7593/MagicalRequiredFields.git
```

Download from [Here](https://github.com/fabian7593/MagicalRequiredFields/zipball/master)

Another type download by Bintray from [ ![Download](https://api.bintray.com/packages/fabian7593/maven/MagicalRequiredFields/images/download.svg) ](https://bintray.com/fabian7593/maven/MagicalRequiredFields/_latestVersion)

And you can add the jcenter bintray library in dependecies, like this:
```bash
  compile 'com.frosquivel:magicalrequiredfields:4.0'
```

<br><br>
### How to use

If you need to validate the components like a "required fields" this library is the heaven for you :D.<br>
You only need to download this example, or import the libraries in yoour project, but if you prefer it for fastest and easier add library to your project, you can use the gradle dependency, you have to add these lines in your build.gradle file:

```bash
repositories {
....
    jcenter()
}

dependencies {
....
    compile 'com.frosquivel:magicalrequiredfields:4.0'
}
```

<br><br>
## Usage
You only need to import the library for use this.<br>
The method of the library return false if any component have empty value or not pass the validate.
<br>
####For example:
If your have a EditText and you validate it, with this library,and you not entry any value, the method return false, but if you entry any value the method return true.<br>

####Description Example
This example have some of the components that's the app supports. In this time are 
*EditText
*Spinner
*RadioButton
*CheckBox 


####Code Implementation
This is only for example, you need to fill the spinner with another form.
<br>
The spinner is fill with this values in the string.xml
```bash
   <string-array name="planets_array">
        <item>  </item>
        <item>Mercury</item>
        <item>Venus</item>
        <item>Earth</item>
        <item>Mars</item>
        <item>Jupiter</item>
        <item>Saturn</item>
        <item>Uranus</item>
        <item>Neptune</item>
    </string-array>
```

<br>
You need to import the library

```bash
import com.frosquivel.magicalrequiredfields.MagicalRequiredFields;
```

<br>
The method of this example is static and you not have to create the instance of this.<br>
You need to pass as parameters the list of your views to validate, and the message if you need to show in the set error message.<br>
```bash
                List<View> listObj = new ArrayList<View>();
                listObj.add(yourEditText);
                listObj.add(yourSpinner);

                Boolean validateFields =
                        MagicalRequiredFields.validateReq(listObj,"This is an required field");

                if(validateFields){
                    Toast.makeText(getApplicationContext(), "You passed the test", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(), "You don't passed the test", Toast.LENGTH_SHORT).show();
                }
```
<br>
In the case of check box and radio button you need to group this for validate in group and not in individual form. 
You need to pass the list of your vies and a list of lists of views like this:

```bash
                List<View> listObj = new ArrayList<View>();
                listObj.add(yourEditText);
                listObj.add(yourSpinner);

                List<View> listObjRadioGroup = new ArrayList<View>();
                listObjRadioGroup.add(radio1);
                listObjRadioGroup.add(radio2);

                List<View> listObjCheckBoxGroup = new ArrayList<View>();
                listObjCheckBoxGroup.add(checkBox1);
                listObjCheckBoxGroup.add(checkBox2);

                List<List<View>> listOfListViewsGroup = new ArrayList<List<View>>();
                listOfListViewsGroup.add(listObjRadioGroup);
                listOfListViewsGroup.add(listObjCheckBoxGroup);

                Boolean validateFields =
                        MagicalRequiredFields.validateReq(listObj,listOfListViewsGroup,"This is an required field");

                if(validateFields){
                    Toast.makeText(getApplicationContext(), "You passed the test", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(), "You don't passed the test", Toast.LENGTH_SHORT).show();
                }

            }
        });
```

<br><br>
##Documentation
All the code has a internal documentation for more explanation of this example.

<br><br>
##Preview of Example
![alt tag](https://github.com/fabian7593/Scroll-Infinite-ListView-Plugin/blob/master/video.gif)


<br><br>
## License
Source code can be found on [github](https://github.com/fabian7593/MagicalRequiredFields)<br>
Licenced under [APACHE 2.0](http://www.apache.org/licenses/LICENSE-2.0).
<br><br>

## About Developer
Developed by [Fabian Rosales](http://www.frosquivel.com)<br>
Known as [Frosquivel Developer](http://www.frosquivel.com)<br>
Web Page [www.frosquivel.com](http://www.frosquivel.com)<br>
Blog (Spanish) [www.frosquivel.com/blog](http://www.frosquivel.com/blog)<br>


