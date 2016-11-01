## Example Sundial Ratpack App

And example of using https://github.com/timmolter/Sundial in Ratpack

One oddity is that currently the `StartEvent` never seems to have `isReload()` returning
true when running in continuous mode with:

```
./gradlew -t run
```