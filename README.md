# Firebase-Sdk
这是使用Firebase-SDK接入的谷歌登陆流程，请注意，它需要`sxk-game-sdk`才能使用。

# 配置proejct.xml
```xml
<haxelib name="google-sdk"/>
```

# 配置google-services.json文件
需要将`google-services.json`文件配置到根应用目录下（app），一般可以通过assets标签导入：
```xml
<assets path="google-services.json" rename="bin/app/google-services.json"/>
```
> 该配置从`firebase`后台下载

# 相关文档
[Firebase控制台](https://console.firebase.google.com/)
