# USE CASE: 4 Produce a report that shows the number of people, people living in cities and not living in cities.

## CHARACTERISTIC INFORMATION

### Goal in Context

As an Organisation I want to produce a report that shows the number of people, people living in cities and not living in cities defined by either country, region or continent.

### Scope

Organisation.

### Level

Primary task.

### Preconditions

We know either the number of people, people living in cities and not living in cities in either a country, region or continent. Database contains population data.

### Success End Condition

A report is available to the Organisation to provide to the Organisation.

### Failed End Condition

No report is produced.

### Primary Actor

Organisation.

### Trigger

A request for total number of people, people living in cities and people not living in cities data is sent to organisation.

## MAIN SUCCESS SCENARIO

1. Organisation requests number of people, people living in cities and not living in cities defined by either the country, region or continent.
2. Organisation captures number of people, people living in cities and not living in cities defined by either the country, region or continent to get population information for.
3. Organisation extracts number of people, people living in cities and not living in cities.
4. Organisation provides report to Organisation.

## EXTENSIONS

3. **Country, region or continent not in database**:
    i. Organisation informs Organisation either region or continent not in database.

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: Release v0.2