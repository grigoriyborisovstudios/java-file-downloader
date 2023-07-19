
# Simple Java Downloader

A simple java downloader library made with java. 

## Installation

Install my-project with jitpack

#### maven: 

```bash
    <repositories>
		<repository>
		    <id>jitpack.io</id>
		    <url>https://jitpack.io</url>
		</repository>
	</repositories>

    <dependency>
	    <groupId>com.github.grigoriyborisovstudios</groupId>
	    <artifactId>java-file-downloader</artifactId>
	    <version>Tag</version>
	</dependency>
```

#### gradle:

```gradle
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}

    dependencies {
	        implementation 'com.github.grigoriyborisovstudios:java-file-downloader:Tag'
	}
```
    
## Contributing

Contributions are always welcome!


## Used By

This project is used by the following companies:

- Grigoriy Borisov Studios


## Usage/Examples

```java
import ua.grigoriyborisov.downloader.Downloader;

import java.net.MalformedURLException;
import java.net.URL;

public class Main {
    public static void main(String[] args) {
        new Thread() {
            @Override
            public void run() {
                super.run();
                final Downloader downloader;
                try {
                    downloader = new Downloader(new URL("http://www.java2s.com/Code/JarDownload/vecmath/vecmath.jar.zip"), new File("vecmath.zip"));
                } catch (MalformedURLException e) {
                    throw new RuntimeException(e);
                }
                downloader.begin();
            }
        }.start();
    }
}

```


## Authors

- [@realestivory](https://www.github.com/realestivory)


