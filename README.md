# MaterialDesignIcons
Lib that imports all the vector drawables from materialdesignicons.com into your R.drawable/

##usage:

Reference lib from jcenter:
```groovy 
  compile 'com.pavelsikun:materialdesignicons:1.0' //uploading right now (00:29 EEST 08.06.2016)
```
Done! Clean/Build so project updates list of resources. All the drawables are awailable through:
```xml
R.drawable/zzz_*icon_name_here*
```

Icons follow the same naming scheme as on [materialdesignicons.com](https://materialdesignicons.com/), though they start with "zzz_" (to make them less cluttery for your resource-list) and every dash('-') is replaced with underscore. That's it.

All icons are "#000000", so tint them manually:
```java
  Drawable icon = ContextCompat.getDrawable(this, R.drawable.zzz_github);
  icon.setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_ATOP);
```

-------
Check out the [sample project](sample) for more details.


##Licence
    Copyright 2016 Pavel Sikun.

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
