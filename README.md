
# Simple Java Downloader

A simple java downloader library made with java. 

## Installation

Install my-project with jitpack

```bash
    pretend there's jitpack maven or gradle download
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
        try {
            final Downloader downloader = new Downloader(new URL("http://www.google.com"));
            downloader.begin();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}

```

