# Jetpack Compose Sample App – Clean Architecture + MVI

This project demonstrates a **modern scalable architecture** for Android apps built with **Jetpack Compose**.  
It is a simple **List/Detail** application that showcases how to structure code using **Clean Architecture** and **MVI** with the latest Android libraries.

---

## 🏗️ Architecture

The project follows **Clean Architecture** with **MVI (Model–View–Intent)** for state management.

- **Core**  
  Shared modules for `data`, `domain`, and `presentation`.
- **Feature modules** (e.g. `sampleFeature`)  
  Each feature contains its own `data`, `domain`, and `presentation` packages.  
- **Navigation** handled with [Navigation Compose](https://developer.android.com/jetpack/compose/navigation).  
- **Dependency Injection** with [Hilt](https://developer.android.com/training/dependency-injection/hilt-android).  
- **Database** with Room as the **single source of truth**.  
- **Networking** with [Ktor Client](https://ktor.io/) (currently mocked API).  

---

## ⚙️ Tech Stack

- **UI**: Jetpack Compose, Material 3, Previews  
- **State Management**: MVI + ViewModels + StateFlow + sealed classes  
- **Navigation**: Navigation Compose (type-safe routes)  
- **Coroutines + Flow** for async/reactive handling  
- **DI**: Hilt  
- **Networking**: Ktor (mocked)  
- **Persistence**: Room Database  
- **Gradle**: Version catalog (`libs.versions.toml`) with Kotlin DSL  

---

## 📂 Project Structure
```text
app/
 ┣ core/
 ┃ ┣ data/             # Shared data layer (api, db, repository base)
 ┃ ┣ domain/           # Domain layer (models, use cases, repository interfaces)
 ┃ ┣ presentation/     # Shared presentation utilities
 ┃
 ┣ di/                 # Hilt modules
 ┣ navigation/         # Navigation graph & routes
 ┣ sampleFeature/      # Example feature module (list/detail)
 ┃ ┣ data/
 ┃ ┣ domain/
 ┃ ┣ presentation/
 ┃
 ┣ ui/                 # App-wide UI components (themes, design system)
 ┣ MainActivity.kt     # Entry point
 ┗ MyApp.kt            
```

## 🔄 MVI Flow Example

Here’s how the **ItemList** feature works:

1. **UI** sends an `ItemListAction` to the `ViewModel`.  
2. **ViewModel** updates its `StateFlow<ItemListUIState>`.  
3. **UI** collects state via `collectAsStateWithLifecycle()`.  
4. Errors or one-time messages are sent via `events: Flow<ItemListEvents>`.  
5. `HandleEvents()` composable observes and renders dialogs/snackbars.  

**Example:**

```kotlin
val state by viewModel.state.collectAsStateWithLifecycle()

HandleEvents(events = viewModel.events)

ItemListScreen(
    state = state,
    onAction = { action -> viewModel.onAction(action) }
)
```

## 🗄️ Data Layer

The **Repository** is the central point that merges **remote** and **local** data sources.  
It ensures that the **Room database is the single source of truth**.

### Responsibilities

- Fetches list of items from `ItemApi` (Ktor-based, currently mocked)  
- Persists data in `ItemDao` (Room database)  
- Provides reactive streams via `Flow<List<Item>>` so the UI can observe changes  

### Example – Observing Items

```kotlin
override fun observeItemList(): Flow<List<Item>> {
    return itemDao.observeAll().map { entities -> entities.map { it.toDomain() } }
}
```

## ✅ Key Takeaways

- Clean Architecture + MVI in Jetpack Compose  
- Single source of truth via Room DB  
- Repository pattern merging API + persistence  
- Sealed classes for state, actions, and events  
- Scalable feature-based packaging  

---

## 📜 License

MIT License – free to use and modify.

