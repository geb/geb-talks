## Performance

Functional tests are slow. There are lots of moving pieces.

Coping strategies:

1. Pick your tests wisely
2. Group tests into functional areas
3. Use raw HTTP and HTML scraping
4. Parallelize

## Parallelization

Managing parallel tests against one app is difficult.

Instead, group the tests and use multiple app instances.

See [Tomas Lin's post and example script](http://fbflex.wordpress.com/2011/12/01/a-script-to-run-grails-functional-tests-in-parallel/ "A Script to run Grails Functional Tests in Parallel  | Tomás Lin&#8217;s Programming Brain Dump") for a start on this.