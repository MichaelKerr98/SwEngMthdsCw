# USE CASE: 3 Produce a report that shows the top populated capital cities in either a continent, region or the world.

## CHARACTERISTIC INFORMATION

### Goal in Context

As an Organisation I want to produce a report that shows the top populated capital cities in either a continent, region or the world, the number of countries displayed is defined by the user at runtime.

### Scope

Organisation.

### Level

Primary task.

### Preconditions

We know either the top populated capital city(s) in either the continent, region or the world. Database contains population data.

### Success End Condition

A report is available to the Organisation to provide to the user.

### Failed End Condition

No report is produced.

### Primary Actor

Organisation.

### Trigger

A request for top populated capital cities data is sent to organisation.

## MAIN SUCCESS SCENARIO

1. Organisation requests top populated capital city information for either a continent, region or the world. Number of cities displayed defined by user at runtime.
2. Organisation captures top populated capital city information for either a continent, region or the world to get population information for.
3. Organisation extracts current population of capital city.
4. Organisation provides report to user.

## EXTENSIONS

3. **Region or continent not in database**:
    i. Organisation informs user either region or continent not in database.

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: Release v0.2