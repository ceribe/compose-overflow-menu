# How to prepare a new library:
1. Rename module
2. Rename package
3. Find all other instances of "ceribelibname" (Ctrl + F) and rename them
4. Prepare README.md and remove this list

Here add jitpack badge

# Overflow Menu
Here short description and screenshots/gifs

# How to add to project
### Step 1. Add the JitPack repository to your build file
Add it in your root build.gradle at the end of repositories:
```gradle
  allprojects {
     repositories {
       ....
       maven { url 'https://jitpack.io' }
     }
  }
```
### Step 2. Add the dependency
```gradle
  dependencies {
       Here place dependency provided by jitpack
  }
```

# How to use
Here add some sample code

# License
```
Copyright 2021 Ceribe Kagami

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    https://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
