#/bin/sh

git clone https://github.com/jheintz/sample-riak-testing.git
cd sample-riak-testing.git

git checkout step1  # initial test, fails
mvn test
# eclipse show SmokeTest failure

git checkout step2  # add riak downloader
mvn test
# I don't know why eclipse has maven failure...
# eclipse show riak-build.xml
# eclipse show pom.xml

git checkout step3  # add parameterized many tests
# eclipse show ManySmokeTest

ant -f riak-build.xml stop