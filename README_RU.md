# GlowCore [![GPLv3 License](https://img.shields.io/badge/License-GPL%20v3-yellow.svg)](https://opensource.org/licenses/)
**Версия:** `0.0.1-alpha` | **Пакет:** `org.gfs.glowcore`

Минималистичный игровой движок на Java/LWJGL с эргономичным API для быстрой разработки.

[English Version](README.md)

## ✨ Ключевые преимущества
- **Интуитивный API** - лаконичные методы (`windowInit(width, height, title)`, `loadTexture(path)`)
- **Безопасное управление ресурсами** - автоматическое освобождение памяти

## ⚙️ Требования
| Компонент | Минимальная версия |
| --------- | -------------- |
| Java | 17+ |
| OpenGL | 4.6+ |
| Видеокарта | NVIDIA 900+ / AMD R9 300+ |
| ОС | Windows, Linux, macOS |

## 📦 Установка

### 0.0.1-alpha:

**Maven**

pom.xml:
**Замените: FILENAME на имя файла релиза! PATH-TO-JAR на ваш путь к .jar!**

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

## 🔄 Версионирование
Используется [Semantic Versioning](https://semver.org/):
- `0.0.1-alpha` - начальная альфа-версия
- `0.0.2-alpha` - следующая запланированная альфа-версия после добавления новой функциональности
- Формат: `MAJOR.MINOR.PATCH[-stage]`
- Стадии: `alpha` → `beta` → `rc` → стабильный релиз

## 📜 Лицензия
Проект распространяется под лицензией [GNU GPLv3](LICENSE). Обязательно:
- Сохраните копию лицензии в вашем проекте
- Указывайте изменения в модифицированных версиях
- Распространяйте исходный код производных работ

> 🚧 **Активная разработка**
> Скриншоты и расширенные примеры будут добавлены в следующих релизах
> Вопросы и предложения: [GitHub Issues](https://github.com/IsThisALis/GlowCore/issues)

> 🔄 **Планируемые изменения**
> Планируется переход на более мягкую лицензию в будущих релизах