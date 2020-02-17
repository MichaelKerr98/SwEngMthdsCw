# USE CASE: 1 Produce a report that shows either the cities, continents, regions and top number of countries population

## CHARACTERISTIC INFORMATION

### Goal in Context

As an Organisation I want to produce a report that shows the cities, continents, regions and top number of countries population as the number of countries displayed is defined by the user at runtime.

### Scope

Organisation.

### Level

Primary task.

### Preconditions

We know the city(s), continent(s), region(s) and/or top country(s).  Database contains population data.

### Success End Condition

A report is available to the Organisation to provide to the user.

### Failed End Condition

No report is produced.

### Primary Actor

Organisation.

### Trigger

A request for population data is sent to organisation.

## MAIN SUCCESS SCENARIO

1. User requests population information for city(s), continent(s), region(s) and/or top country(s) with number of countries displayed defined by user.
2. Organisation captures either city, continental, regional or list of top countries to get population information for.
3. Organisation extracts current population of either city, continental, regional or top countries. Number of countries displayed given by user.
4. Organisation provides report to user.

## EXTENSIONS

3. **City(s), continent(s), region(s) or country(s) not in database**:
    i. Organisation informs user city(s), continent(s), region(s) or country(s) not in database.

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: Release v0.2