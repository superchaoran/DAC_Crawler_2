Hello all,

MySQL Connector/J 5.1.33, a maintenance release of the production 5.1
branch has been released. Connector/J is the Type-IV pure-Java JDBC
driver for MySQL.

Version 5.1.33 is a maintenance release of the production 5.1 branch.
It is suitable for use with MySQL server versions 5.5 and 5.6.

MySQL Connector Java is available in source and binary form from the
Connector/J download pages at
http://dev.mysql.com/downloads/connector/j/5.1.html

MySQL Connector Java (Commercial) is already available for download
on the My Oracle Support (MOS) website. This release will be available
on eDelivery (OSDC) in next month's upload cycle.

As always, we recommend that you check the "CHANGES" file in the
download archive to be aware of changes in behavior that might affect
your application.

MySQL Connector/J 5.1.33 includes the following general bug fixes and
improvements, also available in more detail on
http://dev.mysql.com/doc/relnotes/connector-j/en/news-5-1-33.html :


Changes in MySQL Connector/J 5.1.33 2014-09-25
 

 Bugs Fixed

     * Many parameters specified with options when making an Ant
       build of Connector/J from source (for example,
       com.mysql.jdbc.testsuite.url.sha256default) were not set as
       system properties and thus were not available for use in the
       JUnit tests in the testsuite. With this fix, all
       com.mysql.jdbc.test.* and com.mysql.jdbc.testsuite.*
       parameters are forwarded to the JUnit tests. (Bug #19505524)

     * XA connections failed with a class cast exception for a
       load-balanced configuration with
       pinGlobalTxToPhysicalConnection=true. This was because some
       XA-related classes used com.mysql.jdbc.ConnectionImpl in
       method parameters during calls. This fix makes the classes use
       com.mysql.jdbc.Connection instead in those cases. (Bug
       #19450418, Bug #73594)

     * The 4-byte UTF8 (utfbmb4) character encoding could not be used
       with Connector/J when the server collation was set to anything
       other than the default value (utf8mb4_general_ci). This fix
       makes Connector/J detect and set the proper character mapping
       for any utfmb4 collation. (Bug #19479242, Bug #73663)

     * changeUser() calls might result in a connection exception
       ("Got packets out of order") or a freeze if the useCompression
       option was set to true. (Bug #19354014, Bug #19443777, Bug
       #73577)

     * The MANIFEST.MF file for the JAR package of Connector/J
       included an empty line between the attributes Import-Package
       and Name, which was interpreted as a mark for the end of the
       main section of the manifest file. This fix removes the empty
       line. (Bug #19365473, Bug #73474)

     * The tests testByteStreamInsert and testUseCompress in the
       Connector/J testsuite failed with the message "Row size too
       large (> 8126)..." when they were run against the MySQL server
       version 5.6.20. This is due to a known limitation with the
       server version, for which innodb_log_file_size has to be set
       to a value greater than 10 times the largest BLOB data size
       found in the rows of the tables plus the length of other
       variable length fields (that is, VARCHAR, VARBINARY, and TEXT
       type fields) (see the MySQL 5.6.20 changelog
       (http://dev.mysql.com/doc/relnotes/mysql/5.6/en/news-5-6-20.ht
       ml) for details). This fix adds, for MySQL 5.6.20, a check for
       innodb_log_file_size to assert that its value is 335544320 or
       larger and throws an exception if it is not so, asking the
       user to increase the size of innodb_log_file_size. (Bug
       #19172037)

     * Using Java 6 or later, running LOAD DATA INFILE with a
       prepared statement resulted in an IndexOutOfBoundsException.
       This was a regression introduced by an issue in the patch for
       Bug #72008, which has now been fixed. (Bug #19171665, Bug
       #73163)

     * Connector/J failed the test for Bug# 64205 in the testsuite,
       thus might return a garbled error message for an invalid query
       when connected to MySQL server 5.5 or later. The failure was a
       regression introduced by the fix for Bug #18836319, which made
       the issuing of SET NAMES dependent on the character set
       difference between the server and the connection. This fix
       corrects the way by which the error messages are interpreted,
       so that they will come out right at any stage of a connection.
       (Bug #19145408)

     * Errors occur when Connector/J mapped Windows time zones to
       Olson time zones for "Caucasus Standard Time" and "Georgian
       Standard Time". This fix corrected and updated all the
       time-zone mappings in Connector/J using the data from the IANA
       Time Database and the Unicode Common Locale Data Repository
       (CLDR) v.24. (Bug #17527948, Bug #70436)

     * The test case testsuite.simple.XATest.testRecover failed when
       run against MySQL servers 5.7.0 to 5.7.4, because Connector/J
       did not understand the new output format for XA RECVOER that
       was introduced since MySQL 5.7.0 for fixing Bug #19505524.
       That fix has recently been reverted in MySQL 5.7.5, so that XA
       RECOVER output is now, by default, in the old format again.
       The test case, which runs well with MySQL 5.7.5, is now
       skipped for server versions 5.7.0-5.7.4. (Bug #17441747)
       
       
Documentation
--------------
Online: http://dev.mysql.com/doc/connector-j/en/index.html

Reporting Bugs
---------------
We welcome and appreciate your feedback and bug reports:
http://bugs.mysql.com/


On behalf of Oracle/MySQL Build Team,
Sreedhar S
