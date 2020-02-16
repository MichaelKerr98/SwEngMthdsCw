# USE CASE: 6 Produce a report that provides the number of people who speak from a selection of languages from greatest number to smallest, including the percentage of the world population.

## CHARACTERISTIC INFORMATION

### Goal in Context

As an Organisation I want to produce a report that that provides the number of people who speak from a selection of languages from greatest number to smallest, including the percentage of the world population: Chinese. English, Hindi, Spanish and Arabic..

### Scope

Organisation.

### Level

Primary task.

### Preconditions

We know the number of people who speak the select languages. Database contains population data.

### Success End Condition

A report is available to the Organisation to provide to the Organisation.

### Failed End Condition

No report is produced.

### Primary Actor

Organisation.

### Trigger

A request for the number of people who speak the selected languages from greatest to smallest, including the percentage of the world population is sent to organisation.

## MAIN SUCCESS SCENARIO

1. Organisation requests number of people who speak the selected languages from greatest to smallest, including the percentage of the world population.
2. Organisation captures number of people who speak the selected languages from greatest to smallest, including the percentage of the world population to get population information for.
3. Organisation extracts number of people who speak the selected languages from greatest to smallest, including the percentage of the world population.
4. Organisation provides report to Organisation.

## EXTENSIONS

3. **Language or population information not in database**:
    i. Organisation informs Organisation either the language or population not in database.

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: Release v0.2