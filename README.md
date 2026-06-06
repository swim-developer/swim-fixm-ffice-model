# fixm-ffice-model

JAXB bindings for FIXM schemas used by the FF-ICE service.

## What This Project Provides

- Java classes generated from FIXM XSD schemas via JAXB (XJC)
- Thread-safe unmarshaller pool with XSD validation (FficeUnmarshallerPool)
- Standalone XSD validator (FficeXsdValidator)
- Secure XML parsing (XXE prevention)

## Prerequisites

- JDK 21
- Maven 3.9+
- `swim-developer` parent POM installed in local Maven repository

## Install

```bash
./mvnw clean install -DskipTests
```

## Regenerate JAXB Classes

After modifying XSD schemas or binding files:

```bash
./mvnw process-sources -Pgenerate-xjc
```

This deletes old generated packages, runs XJC against `FficeMessage.xsd`, and copies the generated classes into `src/main/java/`.

Hand-written validation classes in the `validation` package are preserved.

## Package Structure

| Package | Classes | XSD Namespace | Description |
|---------|---------|---------------|-------------|
| `aero.fixm.base` | 157 | `http://www.fixm.aero/base/4.3` | FIXM base types (measures, geometry, references) |
| `aero.fixm.flight` | 299 | `http://www.fixm.aero/flight/4.3` | FIXM flight types (route, trajectory, aircraft) |
| `aero.fixm.ffice` | 57 | `http://www.fixm.aero/app/ffice/1.1` | FF-ICE message types and 12 message templates |
| `aero.fixm.ffice.bugfix` | 4 | `http://www.fixm.aero/ffice/1.1/bugfix/2024.04.30` | Bug fix extensions (flightRulesCategory, modifiedRouteItemReference) |
| `aero.fixm.ffice.validation` | 2 | -- | Hand-written unmarshaller pool and XSD validator |

Generated from 171 XSD schemas (FIXM 4.3 core + FF-ICE Application 1.1.0 + bug fix extension).

## Technology

| Component | Version |
|-----------|---------|
| Java | 21 |
| Jakarta XML Binding API | 4.0.5 |
| GlassFish JAXB Runtime | 4.0.7 |
| JAXB Maven Plugin | 4.0.12 |

## License

Licensed under the [Apache License 2.0](LICENSE).
