# GlowCore [![GPLv3 License](https://img.shields.io/badge/License-GPL%20v3-yellow.svg)](https://opensource.org/licenses/)
**Version:** `0.0.1-alpha` | **Package:** `org.gfs.glowcore`

A minimalistic game engine in Java/LWJGL with an ergonomic API for rapid development.

[English Version](README.md)

## ✨ Key Advantages
- **Intuitive API** - concise methods (`windowInit(width, height, title)`, `loadTexture(path)`)
- **Safe resource management** - automatic memory deallocation

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
**Replace: FILENAME with the release file name! PATH-TO-JAR with your path to .jar!**

```xml
<dependency>
<groupId>org.gfs</groupId>
<artifactId>glowcore</artifactId>
<version>VERSION</version>
<scope>system</scope>
<systemPath>PATH-TO-JAR/FILENAME.jar</systemPath>
</dependency>
```

**Gradle**

Kotlin DSL:
```kts
dependencies {
implementation(files("libs/FILENAME.jar"))
}
```

Groovy DSL:
```groovy
dependencies {
implementation files('libs/FILENAME.jar')
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
> Questions and suggestions: [GitHub Issues](https://github.com/IsThisALis/GlowCore/issues)

> 🔄 **Planned Changes**
> Planned transition to a more permissive license in future releases