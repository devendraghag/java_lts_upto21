# Java Learning Lab · Up to Java 21

**Explore a concept. Read the code. Predict the result. Run it yourself.**

![Java 21](https://img.shields.io/badge/Java-21-ED8B00?style=flat-square)
![Maven Wrapper](https://img.shields.io/badge/Build-Maven_Wrapper-C71A36?style=flat-square&logo=apachemaven&logoColor=white)
![Hands-on practice](https://img.shields.io/badge/Learning-Hands--on-2563EB?style=flat-square)

A collection of focused Java programs for building language fundamentals, exploring modern features and revising for technical interviews. Browse examples across object-oriented programming, collections, streams, concurrency and Java features through Java 21.

[Quick start](#quick-start) · [Topic explorer](#topic-explorer) · [Learning paths](#choose-a-learning-path) · [Interview revision](#interview-revision) · [Project structure](#project-structure)

## What you can explore

- **Core Java:** variables, types, control flow, strings and exception handling.
- **Object-oriented design:** inheritance, interfaces, composition, abstraction and polymorphism.
- **Data processing:** collections, generics, comparators, streams and collectors.
- **Concurrency:** threads, synchronization, blocking queues, CompletableFuture and virtual threads.
- **Modern Java:** records, sealed classes, text blocks, pattern matching and sequenced collections.

The examples live in topic folders, so you can study one concept at a time or use the repository as a reference alongside your own projects.

## Quick start

### Prerequisites

- **JDK 21 or newer**, with `java` and `javac` available on your PATH.
- **Git** to clone the repository.
- Network access for the Maven Wrapper and dependencies on the first build.

```bash
git clone https://github.com/devendraghag/java_lts_upto21.git
cd java_lts_upto21
java -version
javac -version
```

### Build

**Windows PowerShell**

```powershell
.\mvnw.cmd clean package
```

**macOS / Linux**

```bash
./mvnw clean package
```

The examples target Java 21. The Maven Wrapper downloads the pinned Maven distribution on its first run, so a system Maven installation is not required. Maven reads the project-local `.mvn/settings.xml` instead of machine-level Maven settings.

### Run your first example

After building, run the [entry-point example](src/main/java/com/example/example/helloworldways/HelloWorldEntryPointDemo.java):

```bash
java -cp target/classes com.example.helloworldways.HelloWorldEntryPointDemo Devendra
```

Expected output:

```text
Hello, Devendra!
Hello from an overloaded helper method.
```

Prefer an IDE? Open the repository as a Maven project, select JDK 21 or newer, then run an example class with a `public static void main(String[] args)` method. Use the package declaration inside each source file to identify its fully qualified class name.

## Topic explorer

| Area | Jump into the examples |
| --- | --- |
| Fundamentals | [Variables](src/main/java/com/example/example/variables) · [Data types](src/main/java/com/example/example/datatypes) · [Operators](src/main/java/com/example/example/operators) · [Control flow](src/main/java/com/example/example/ifstatements) · [Loops](src/main/java/com/example/example/forloop) |
| Object-oriented Java | [Constructors](src/main/java/com/example/example/constructors) · [Inheritance](src/main/java/com/example/example/inheritance) · [Interfaces](src/main/java/com/example/example/interfaces) · [Abstract classes](src/main/java/com/example/example/abstractclass) · [Composition](src/main/java/com/example/example/composition) |
| Methods and behavior | [Overloading](src/main/java/com/example/example/methodoverloading) · [Overriding](src/main/java/com/example/example/methodoverriding) · [Dynamic dispatch](src/main/java/com/example/example/dynamicmethoddispatch) · [Call by value](src/main/java/com/example/example/callbyvalue) |
| Strings and errors | [Strings](src/main/java/com/example/example/strings) · [StringBuilder](src/main/java/com/example/example/stringbuilder) · [String methods](src/main/java/com/example/example/stringmethods) · [Exception handling](src/main/java/com/example/example/exceptionhandling) |
| Collections and types | [Collection classes](src/main/java/com/example/example/collectionclasses) · [Generics](src/main/java/com/example/example/generics) · [Comparable](src/main/java/com/example/example/comparable) · [Comparator](src/main/java/com/example/example/comparator) · [Collection conversions](src/main/java/com/example/example/collectionconversions) |
| Functional Java | [Lambdas](src/main/java/com/example/example/lambdaexpressions) · [Functional interfaces](src/main/java/com/example/example/functionalinterfaces) · [Method references](src/main/java/com/example/example/methodreferences) · [Optional](src/main/java/com/example/example/optionalclass) |
| Streams and collectors | [Stream creation](src/main/java/com/example/example/streamcreation) · [Intermediate operations](src/main/java/com/example/example/intermediateoperations) · [Terminal operations](src/main/java/com/example/example/terminaloperations) · [Collectors](src/main/java/com/example/example/collectors) · [Primitive streams](src/main/java/com/example/example/primitivestreams) |
| Concurrency | [Multithreading](src/main/java/com/example/example/multithreading) · [Synchronization](src/main/java/com/example/example/synchronization) · [Blocking queues](src/main/java/com/example/example/blockingqueue) · [CompletableFuture](src/main/java/com/example/example/completablefuture) · [Virtual threads](src/main/java/com/example/example/virtualthreads) |
| Modern language features | [Records](src/main/java/com/example/example/records) · [Sealed classes](src/main/java/com/example/example/sealedclasses) · [Text blocks](src/main/java/com/example/example/textblocks) · [Switch expressions](src/main/java/com/example/example/switchexpressions) · [Local type inference](src/main/java/com/example/example/localvariabletypeinference) |
| Pattern matching and collections | [Pattern matching for instanceof](src/main/java/com/example/example/patternmatchinginstanceof) · [Pattern matching for switch](src/main/java/com/example/example/patternmatchingforswitch) · [Record patterns](src/main/java/com/example/example/recordpatterns) · [Sequenced collections](src/main/java/com/example/example/sequencedcollections) |
| Further practice | [Interview programs](src/main/java/com/example/example/interviewprograms) · [Design patterns](src/main/java/com/example/example/designpattern) · [HTTP Client](src/main/java/com/example/example/httpclientapi) · [Serialization](src/main/java/com/example/example/serialization) |

[Browse all source folders](src/main/java/com/example/example/)

## Choose a learning path

| Your goal | Suggested route |
| --- | --- |
| Learn Java fundamentals | Variables and types → control flow → methods → strings → exceptions |
| Strengthen object-oriented design | Constructors → inheritance → interfaces → composition → method overriding |
| Get comfortable with data processing | Collections → generics → comparators → lambdas → streams → collectors |
| Explore modern Java | Local type inference → switch expressions → text blocks → records → sealed classes → pattern matching |
| Study concurrency | Multithreading → synchronization → blocking queues → CompletableFuture → virtual threads |

## Interview revision

For each topic, practise explaining:

1. **The rule:** what does the language or API guarantee?
2. **The prediction:** what output do you expect before running the program?
3. **The edge case:** what changes for null, empty input, duplicate values or concurrent execution, where relevant?
4. **The tradeoff:** when would you use this approach in an application?

<details>
<summary><strong>Try a 20-minute revision session</strong></summary>

- 5 minutes: read one example and predict its output.
- 5 minutes: run it and explain the result aloud.
- 5 minutes: change one input locally and check your prediction.
- 5 minutes: write a short explanation of the concept without looking at the source.

</details>

## Project structure

```text
java_lts_upto21/
├── src/main/java/com/example/example/  # Topic-based Java source folders
├── .mvn/                              # Maven Wrapper and project settings
├── mvnw                               # macOS / Linux wrapper
├── mvnw.cmd                           # Windows wrapper
├── pom.xml                            # Java 21 Maven build
└── README.md                          # Learning guide and navigation
```

The source directory has an extra `example` segment; package declarations determine the class names used by the Java launcher. Run individual examples after compiling rather than assuming the JAR has a single application entry point.

## Build troubleshooting

- **Release version 21 not supported:** check `java -version`, `javac -version` and the JDK selected by your IDE or Maven.
- **Class not found:** build from the repository root and use the package declaration plus class name with `java -cp target/classes`.
- **Wrapper permission denied on macOS / Linux:** use `sh mvnw clean package`.
- **Download failure:** check network or proxy access and the project-local Maven settings.

## Scope

This repository is a collection of learning examples and interview practice. The build targets Java 21; individual folders illustrate selected features and concepts, rather than an exhaustive specification or migration guide for every Java release.
