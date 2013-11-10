Devoxx Talk Outline

* What is web / functional testing?
* Approaches
    * Recorder based
    * Imperative scripting
    * Page abstractions
    * Cucumber/Fitnesse etc.
    * Geb & Spock
* Introduce Geb & Spock projects
* Java WebDriver JUnit (demo)
    * Loss of intent through syntactic noise
* WebDriver / Spock (demo)
    * Introduces spock anatomy
    * Demos that Spock runs where JUnit runs, is IDE friendly
* Geb & Spock (demo)
    * Show GebSpec without page objects
* jQuery/Navigator
* Form shortcuts (demo)
* Page objects
    * Demo login (same story as before) with page objects
    * content blocks
    * Navigation (to & at)
* Modules
* Asynchronicity
    * Asynchronous login demo
    * waitFor() & waiting content
    * implicit assertions
    * Groovy truth flexibility
* Reporting
    * Maybe introduce GebReportingSpec here
    * HTML dumps/screenshots
    * Jenkins JUnit attachments
    * (more general point here on optimizing for failure)
* Multi browser demo
    * Introduce config file
    * Slide on browser support
    * SauceLabs (i.e. cloud testing)
* Discussion topics
    * Single page apps
    * interactions DSL
    * multi page & frames 
 

Selling points:
Reduction of boilerplate
Focus on fail fast (to/at - unexpected pages)
Tooling friendly (i.e. is just code, runs in IDE etc)
Composable content definitions
More complete framework (i.e. config, reporting)
Power assert output helps in diagnosing faults (no assertion API)

