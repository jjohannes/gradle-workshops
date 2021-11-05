import de.db.Libs

group = "de.db"
version = "1.0"

extensions.create<Libs>("libs")

// Use Gradle's dependency injection for own types
// objects.newInstance(MyOwnClassWithInjections::class.java)