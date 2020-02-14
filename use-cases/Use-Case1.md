# USE CASE: 1 Produce a report that shows the top number of countries population

## CHARACTERISTIC INFORMATION

### Goal in Context

As an Organisation I want to produce a report that shows the top number of countries population as the number of countries displayed is defined by the user at runtime.

### Scope

Organisation.

### Level

Primary task.

### Preconditions

We know the top countries.  Database contains countries population data.

### Success End Condition

A report is available to the Organisation to provide to the user.

### Failed End Condition

No report is produced.

### Primary Actor

Organisation.

### Trigger

A request for country population data is sent to organisation,

## MAIN SUCCESS SCENARIO

1. User requests country population information for top countries defined by user
2. Organisation captures list of top countries to get population information for.
3. Organisation extracts current population of all top countries given by user
4. Organisation provides report to user.

## EXTENSIONS

3. **Country(s) not in database**:
    i. Organisation informs user country(s) not in database.

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: Release 1.0