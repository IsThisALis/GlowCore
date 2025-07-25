# GlowCore [![GPLv3 License](https://img.shields.io/badge/License-GPL%20v3-yellow.svg)](https://opensource.org/licenses/)
**Version:** `0.0.1-alpha` | **Package:** `org.gfs.glowcore`

A minimalist game engine in Java/LWJGL with an ergonomic API for rapid development.

[Русская версия](README_RU.md)

## ✨ Key Features
- **Intuitive API** - concise methods (`windowInit(width, height, title)`, `loadTexture(path)`)
- **Safe resource management** - automatic memory release

## ⚙️ Requirements
| Component | Minimum Version |
| --------- | -------------- |
| Java | 17+ |
| OpenGL | 4.6+ |
| GPU | NVIDIA 900+ / AMD R9 300+ |
| OS | Windows, Linux, macOS |

## 📦 Installation

### 0.0.1-alpha:

**Maven**

pom.xml:
**Replace VERSION with the release version you are using! Also replace PATH-TO-JAR with your path to the .jar!**

```xml
<dependency>
<groupId>org.gfs</groupId>
<artifactId>glowcore</artifactId>
<version>VERSION</version>
<scope>system</scope>
<systemPath>PATH-TO-JAR/glowcore-VERSION.jar</systemPath>
</dependency>
```

**Gradle**

Kotlin DSL:
```kts
dependencies {
implementation(files("libs/glowcore-VERSION.jar"))
}
```

Groovy DSL:
```groovy
dependencies {
implementation files('libs/glowcore-VERSION.jar')
}
```

## 🚀 Quick Start
1. Create the project structure:
```
src/
└── main/
├── java/
│ └── yourgame/
│ └── Main.java
└── resources/
└── assets/
└── textures/
└── player.png
```

2. Example code (Main.java):
```java
package yourgame;

import org.gfs.glowcore.graphics.*;
import org.gfs.glowcore.graphics.Texture;

public class Main {
public static void main(String[] args) {
// Initialize window
GlowCore.windowInit(1280, 720, "GlowCore Game");

// Load texture
Texture playerTex = Texture.loadTexture("assets/textures/player.png");

// Main loop
GlowCore.loop(() -> {
renderPlayer(playerTex);
});

// Cleanup resources
GlowCore.cleanup();
}

private static void renderPlayer(Texture texture) {
// Rendering implementation
}
}
```

## 🔄 Versioning
Uses [Semantic Versioning](https://semver.org/):
- `0.0.1-alpha` - initial alpha version
- `0.0.2-alpha` - next planned alpha version after adding new functionality
- Format: `MAJOR.MINOR.PATCH[-stage]`
- Stages: `alpha` → `beta` → `rc` → stable release

## 📜 License
The project is licensed under [GNU GPLv3](LICENSE). Required:
- Keep a copy of the license in your project
- Indicate changes in modified versions
- Distribute the source code of derivative works

> 🚧 **Active Development**
> Screenshots and extended examples will be added in future releases
> Questions and suggestions: [GitHub Issues](https://github.com/BronzeCode/GlowCore/issues)

> 🔄 **Planned Changes**
> A transition to a more permissive license is planned for future releases