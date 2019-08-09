# LocaleBasedSpringWebApplication

# What is Localization 
Localization is a service which is used to adapt a product, page or app to a specific market. A localization strategy addresses customer behaviors, purchasing habits, and general cultural 
differences in each country it operates. When a company enters a foreign market, it becomes challenging to offer buyers in the specific country a customer experience that feels comfortable and familiar to them. 
Therefore, setting up country-by-country localization approaches ensures overseas customers benefit from the similar quality experience they would get by using a local business. 

# Benefits of localization 
By implementing a localization strategy which if rich in solution, your business will be in a better position to meet customer needs 
effectively. Localization solutions allow business to successfully increase their potential customer base while avoiding the likely 
pitfalls as a result of cross-cultural marketing. Today, modern solutions offer local SEO review, high-quality translation, and localized engagement to customers throughout the world. Address validation solutions can solve shipping problems as a result of typos or incorrect formatting. Rather than cobbling together diverse solutions for each one of these challenges, an all-inclusive 
localization software handles everything, so you can concentrate on developing exceptional products. 

# Localization 
strategies that work If you want your business to go global, you should employ various strategies. But, which marketing strategy is better? Standardization or localization? Well, both have individual merits, and getting a balance between both 
could be a dilemma if you want to take your business into the global market. Let’s dig into the two of them. How to improve the localization strategy 
What differentiates an organization that merely does business in another country and one that has successful and long-lasting growth is its localization strategy. Here are some must-have localization tips that 
you can apply to your business or company. Which is based on : 

* Messages 
* Date and Time 
* Number Formats 
* Currencies 
* Phone Numbers 

This is main to make our organization as Localization. In other words we can say that our organization is going to be Global. So  we are going to implements these factors in our Application. 

# Quick links
*   https://github.com/Er-Adarsh-Chauhan/LocaleBasedSpringWebApplication/blob/master/README.md
*   https://www.baeldung.com/java-8-localization
*   https://www.ntu.edu.sg/home/ehchua/programming/java/DateTimeCalendar.html
*   https://javadoc.io/doc/com.googlecode.libphonenumber/libphonenumber/8.10.16

# Quick Examples
Let's 

say you have a string representing a phone number from Switzerland. This
is how you parse/normalize it into a `PhoneNumber` 

object:

```java
String swissNumberStr = "044 668 18 00";
PhoneNumberUtil phoneUtil = PhoneNumberUtil.getInstance();
try {
  

PhoneNumber swissNumberProto = phoneUtil.parse(swissNumberStr, "CH");
} catch (NumberParseException e) {
  

System.err.println("NumberParseException was thrown: " + e.toString());
}
```

At this point, `swissNumberProto` contains:

```json
{
  "country_code": 41,
  "national_number": 446681800
}
```

`PhoneNumber` is a class that was originally auto-generated 

from
`phonenumber.proto` with necessary modifications for efficiency. For details on
the meaning of each field, refer to 

`resources/phonenumber.proto`.

Now let us validate whether the number is valid:

```java
boolean isValid = 

phoneUtil.isValidNumber(swissNumberProto); // returns true
```

There are a few formats supported by the formatting method, 

as illustrated
below:

```java
// Produces "+41 44 668 18 00"
System.out.println(phoneUtil.format(swissNumberProto, 

PhoneNumberFormat.INTERNATIONAL));
// Produces "044 668 18 00"
System.out.println(phoneUtil.format(swissNumberProto, 

PhoneNumberFormat.NATIONAL));
// Produces "+41446681800"
System.out.println(phoneUtil.format(swissNumberProto, 

PhoneNumberFormat.E164));
```

You could also choose to format the number in the way it is dialed from another
country:

```java
// Produces "011 41 44 668 1800", the number when it is dialed in the United States.
System.out.println

(phoneUtil.formatOutOfCountryCallingNumber(swissNumberProto, "US"));
```

# Highlights of functionality

*   Parsing,formatting, and validating phone numbers for all countries/regions of the world.
*   `getLocale()` - give default locale on which our system is configure.
*   `setDefault(Locale locale)` - set default locale explicitly for our system to configure.
*   `ofPattern(String pattern)` -Creates a formatter using the specified pattern. This method will create a formatter based on a 
     simple pattern of letters and symbols as described in the class documentation. For example, d MMM uuuu will format 2011-12-03 as '3 Dec 2011'. 
*   `java.time.format.DateTimeFormatter` - Formatter for printing and parsing date-time objects. This class provides the main application entry point for printing and 
     parsing and provides common implementations of DateTimeFormatter.
*   `java.time.ZoneId.of(String zoneId)` - Obtains an instance of ZoneId from an ID ensuring that the ID is valid and available for use. 
     This method parses the ID producing a ZoneId or ZoneOffset. A ZoneOffset is returned if the ID is 'Z', or starts with '+' or '-'. The result 
      will always be a valid ID for which ZoneRules can be obtained. Parsing matches the zone ID step by step as follows. The formatter will use the default FORMAT locale. 
      This can be changed using withLocale(Locale) on the returned formatter Alternatively use the ofPattern(String, Locale) variant of this method. The returned formatter has no override 
      chronology or zone. It uses SMART resolver style.
*   `LocalDateTime.now()` - A date-time without a time-zone in the ISO-8601 calendar system, such as 2007-12-03T10:15:30. LocalDateTime is an immutable date-time object that represents 
      a date-time, often viewed as year-month-day-hour-minute-second. Other date and time fields, such as day-of-year, day-of-week and week-of-year, can also be accessed. Time is represented to nanosecond precision. For example, 
     the value "2nd October 2007 at 13:45.30.123456789" can be stored in a LocalDateTime. 
*   `ZonedDateTime java.time.LocalDateTime.atZone(ZoneId zone)` - Combines this date-time with a time-zone to create a ZonedDateTime. 
    This returns a ZonedDateTime formed from this date-time at the specified time-zone. The result will match this date-time as closely as possible. Time-zone rules, such as daylight savings, mean that not every local date-time is valid for 
    the specified zone, thus the local date-time may be adjusted. 
*   `String java.time.ZoneId.getId()`  - Gets the unique time-zone ID. This ID uniquely defines this object. The format of an offset based ID is defined by 
    ZoneOffset.getId().
*   `ZonedDateTime java.time.ZonedDateTime.withZoneSameInstant(ZoneId zone)` -Returns a copy of this date-time with a different time-zone, retaining the instant. This method changes the time-zone and retains the 
    instant. This normally results in a change to the local date-time. This method is based on retaining the same instant, thus gaps and overlaps in the local time-line have no effect on the result. To change the offset while 
    keeping the local time, use withZoneSameLocal(ZoneId). 
*   `java.text.SimpleDateFormat` - SimpleDateFormat is a concrete class for formatting and parsing dates in a locale-sensitive manner. It allows for formatting (date → text), parsing 
    (text → date), and normalization. SimpleDateFormat allows you to start by choosing any user-defined patterns for date-time formatting. However, you are encouraged to create a date-time formatter with either getTimeInstance, 
    getDateInstance, or getDateTimeInstance in DateFormat. Each of these class methods can return a date/time formatter initialized with a default format pattern. You may modify the format pattern using the applyPattern methods as desired. 
    For more information on using these methods, see DateFormat. 
*   `TimeZone java.util.TimeZone.getTimeZone(String ID)` - Gets the TimeZone for the given ID.
*   `java.util.concurrent.TimeUnit` - A TimeUnit represents time durations at a given unit of granularity and provides utility methods to convert across units, and to perform timing and delay 
    operations in these units. A TimeUnit does not maintain time information,but only helps organize and use time representations that may be maintained separately across various contexts. A nanosecond is defined as one 
    thousandth of a microsecond, a microsecond as one thousandth of a millisecond, a millisecond as one thousandth of a second, a minute as sixty seconds, an hour as sixty minutes, and a day as twenty four hours.
*   `String java.text.DateFormat.format(Date date)` - Formats a Date into a date/time string. Parameters:date - the time value to be 
     formatted into a time string.Returns:the formatted time string.
*   `Currency java.util.Currency.getInstance(Locale arg0)` - Returns the Currency instance for the country of the given locale. The language and variant components of 
    the locale are ignored. The result may vary over time, as countries change their currencies. For example, for the original member countries of the European Monetary Union, the method returns the old national currencies until 
    December 31, 2001, and the Euro from January 1, 2002, local time of the respective countries. The method returns null for territories that don't have a currency, such as Antarctica.
*   `java.text.NumberFormat.getCurrencyInstance(Locale arg0)` - Returns a currency format for the specified locale.
*   `NumberFormat java.text.NumberFormat.getNumberInstance(Locale inLocale)` - Returns a general-purpose number format for the 
    specified locale.
*   `PhoneNumber` - This element neither has attached source nor attached Javadoc and hence no Javadoc could be found. For this, go for any third party given API. Here, Google given Third party API has used to 
      implements to finding the Phones like PhoneNumbers, its formats, it is valid or not.

# Demo for LocaleBasedSpringWebApplication

## Java Code
*   To implements this application you must use Java version of jdk1.8.0_25. If this number is lower than the Jdk1.8.0_25 then you may       get some issues to compile and run the application.
*   To include the Java code in your application, either integrate with Maven or download the latest jars from the [Maven repository]       (https://repo1.maven.org/maven2/com/googlecode/libphonenumber/libphonenumber/).

# Versioning and Announcements

We generally choose the release number following these guidelines.If any of the changes pushed to master since the last release are incompatible
with the intent / specification of an existing libphonenumber API or may cause libphonenumber (Java) clients to have to change their code to keep
building, we publish a major release. For example, if the last release were 7.8.0, the new one would be 8.10.16

If any of those changes *enable* clients to update their code to take advantage of new functionality, and if clients would have to roll-back these changes in
the event that the release was marked as "bad", we publish a minor release. For example, we'd go from  7.8.0. to 8.10.16.

Otherwise, including when a release contains only [metadata](FAQ.md#metadata_definition) changes, we publish a sub-minor release, e.g. 7.8.0. to 8.10.16.

# Third-party Ports

Several third-party ports of the phone number library are known to us. We share them here in case they're useful for developers.

However, we emphasize that these ports are by developers outside the libphonenumber project. We do not evaluate their quality or influence their
maintenance processes.

*   C#: https://github.com/twcclegg/libphonenumber-csharp
*   Go: https://github.com/nyaruka/phonenumbers
*   Objective-c: https://github.com/iziz/libPhoneNumber-iOS
*   PHP: https://github.com/giggsey/libphonenumber-for-php
*   PostgreSQL in-database types: https://github.com/blm768/pg-libphonenumber
*   Python: https://github.com/daviddrysdale/python-phonenumbers
*   Ruby: https://github.com/mobi/telephone_number
*   Rust: https://github.com/1aim/rust-phonenumber
*   Erlang: https://github.com/marinakr/libphonenumber_erlang

Alternatives to our own versions:

*   Android-optimized: Our Java version loads the metadata from `Class#getResourcesAsStream` and asks that Android apps follow the Android
    loading best practices of repackaging the metadata and loading from `AssetManager#open()` themselves ([FAQ] (https://github.com/google/libphonenumber/blob/master/FAQ.md#optimize-loads)).
    If you don't want to do this, check out the port at https://github.com/MichaelRocks/libphonenumber-android, which does repackage
    the metadata and use `AssetManager#open()`, and may be depended on without needing those specific loading optimizations from clients.
*   Javascript: If you don't want to use our version, which depends on Closure, there are several other options, including https://github.com/catamphetamine/libphonenumber-js - a stripped-down
    rewrite, about 110 KB in size - and https://github.com/seegno/google-libphonenumber - a browserify-compatible wrapper around the original unmodified 
    library installable via npm, which packs the Google Closure library, about 420 KB in size. 
   
# Conclusion
Overall, when localization is done correctly, it can save millions for your business. Imagine how much potential market earnings you can 
lose if local consumers boycott your product or service because they were offended by your marketing message, or they simply didn’t understand it.
Fortunately, with the ways provided above, you can improve your localization strategy and you are guaranteed a safe ride towards the long journey and profits that the global market has saved for you.

