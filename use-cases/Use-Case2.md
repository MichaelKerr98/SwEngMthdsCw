# USE CASE: 2 Produce a report that shows either the population of a city, district, country, region, continent or world

## CHARACTERISTIC INFORMATION

### Goal in Context

As an Organisation I want to produce a report that shows either the population of a city, district, country, region, continent or world.

### Scope

Organisation.

### Level

Primary task.

### Preconditions

We know either the city, district, country, region, continent or world. Database contains population data.

### Success End Condition

A report is available to the Organisation.

### Failed End Condition

No report is produced.

### Primary Actor

Organisation.

### Trigger

A request for population data is sent to organisation.

## MAIN SUCCESS SCENARIO

1. Organisation requests population information for either city, district, country, region, continent or world.
2. Organisation captures either city, district, country, region, continent or world to get population information for.
3. Organisation extracts current population of either city, district, country, region, continent or world.
4. Organisation provides report Organisation.

## EXTENSIONS

3. **City, district, country, region, continent or world not in database**:
    i. Organisation informs Organisation either city, district, country, region, continent or world not in database.

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: Release v0.2