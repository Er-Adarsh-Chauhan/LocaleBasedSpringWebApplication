/**
 * **********************************************************************************************************
*	Created By		:		Adarsh Chauhan.   																*
*	Created Date	: 		30-July-2019      																*
*	Last Modified 	:		09-Aug-2019       																*
*   Description		:		Creation of Locale Based Date and Time for Two different Zones with GMT,Currency*
*							and Number Formats and Phone Number Representation. And Also Locale Based       *
*							Language Change.																*
*************************************************************************************************************
*/


package org.spring.controller;
/**
 * important packages used for Localization 
 */
import javax.servlet.http.HttpServletRequest;
import java.text.*;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.TimeUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.server.i18n.LocaleContextResolver;
import org.springframework.web.servlet.support.RequestContextUtils;
import com.google.i18n.phonenumbers.*;
import com.google.i18n.phonenumbers.PhoneNumberUtil.PhoneNumberFormat;
import com.google.i18n.phonenumbers.Phonenumber.PhoneNumber;
import com.google.i18n.phonenumbers.data.*;
import com.google.i18n.phonenumbers.internal.*;


@Controller
public class HomeController{
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@Autowired
	private MessageSource msgSrc;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model, HttpServletRequest request) {
	
	   /**
	    * give default locale on which our system is configure. 
	    */
	   Locale loc=LocaleContextHolder.getLocale();
	   /**
	    * System.out.println("Locale of LocaleContextHolder is : "+loc);
	    */
	   /**
	    * To get Country codes and Languages in code and locale respectively. 
	    */
	   
	   String currentCountryLanguageName=request.getParameter("locale");
       String currentCountryCode=request.getParameter("code");
      /**
       *  System.out.println("Country Language : "+currentCountryLanguageName+" Code is : "+currentCountryCode);
       */
       
      /**
       *  System.out.println("loc.getLanguage()"+loc.getLanguage());
       */
       
       /**
        * To get language of the given locale.
        */
       String lang=TimeZone.getDefault().getDisplayName();
     /**
      *   System.out.println("lang : "+lang);
      */
       Locale currentLocale=null;
       
       /**
        *  Used for switching in different Locales based on country Languages and its country codes. 
        */
       switch (loc.getLanguage()) {
       
       case "en":
			currentCountryLanguageName="en";
	  	    currentCountryCode="US";
	  	    currentLocale=new Locale(currentCountryLanguageName,currentCountryCode);
	  	    Locale.setDefault(currentLocale);
	  	    break;
       case "fr":
			currentCountryLanguageName="fr";
	  	    currentCountryCode="FR";
	  	    currentLocale=new Locale(currentCountryLanguageName,currentCountryCode);
	  	    Locale.setDefault(currentLocale);
	  	    break;
       case "zh":
			currentCountryLanguageName="zh";
	  	    currentCountryCode="SG";
	  	    currentLocale=new Locale(currentCountryLanguageName,currentCountryCode);
	  	    Locale.setDefault(currentLocale);
	  	    break;
	  default:
		  	currentCountryLanguageName="hi";
	  	    currentCountryCode="IN";
	  	    currentLocale=new Locale(currentCountryLanguageName,currentCountryCode);
	  	    Locale.setDefault(currentLocale);
	  	    break;//if we remove all break stmt then Locale will not change to other Locale.
           
	}
  
  
	   /**
	    * get TimeZone of two different zone id's. 
	    */
	   
	   DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("EEEE, MMMM d, yyyy hh:mm:ss a z");
	   ZoneId fromTimeZone = ZoneId.of("Asia/Kolkata");    //Source timezone
       ZoneId toTimeZone = ZoneId.of("America/New_York");  //Target timezone
        
       LocalDateTime today = LocalDateTime.now();          //Current time
        
       /**
        * Zoned date time at source timezone
        */
       ZonedDateTime currentISTime = today.atZone(fromTimeZone);   
      /**
       * To get zoneId of given Locale
       */
       String zoneIdFrom=fromTimeZone.getId();
       //System.out.println("zoneIdFrom : "+zoneIdFrom);
       /**
        * Zoned date time at target timezone
        */
       ZonedDateTime currentETime = currentISTime.withZoneSameInstant(toTimeZone);
       String zoneIdTo=toTimeZone.getId();
      // System.out.println("zoneIdTo : "+zoneIdTo);
       
     /**
      * difference between two Timezones.
      */
       Date currentDate=new Date();
       //SimpleDateFormat FORMATTER = new SimpleDateFormat("dd/MM/yyyy 'at' hh:mm a 'GMT'Z");
       SimpleDateFormat FORMATTER = new SimpleDateFormat("dd/MM/yyyy 'at' hh:mm a");
       TimeZone etTimeZone1 = TimeZone.getTimeZone("Asia/Kolkata"); //Target timezone
       TimeZone etTimeZone = TimeZone.getTimeZone("America/New_York"); //Target timezone
       
       FORMATTER.setTimeZone(etTimeZone1); 
       
       /**
        * find GMT of given Locale
        */
       long hour=TimeUnit.MILLISECONDS.toHours(etTimeZone1.getRawOffset());
       long minutes=TimeUnit.MILLISECONDS.toMinutes(etTimeZone1.getRawOffset())-TimeUnit.HOURS.toMinutes(hour);
       minutes=Math.abs(minutes);
       
       long hour1=TimeUnit.MILLISECONDS.toHours(etTimeZone.getRawOffset());
       long minutes1=TimeUnit.MILLISECONDS.toMinutes(etTimeZone.getRawOffset())-TimeUnit.HOURS.toMinutes(hour1);
       minutes1=Math.abs(minutes1);
       
		FORMATTER.setTimeZone(etTimeZone1);    
					
		String str1=FORMATTER.format(currentDate)+" "+String.format("GMT+%d:%02d",hour,minutes);  //Date in current timezone
		FORMATTER.setTimeZone(etTimeZone);    
		String str2=FORMATTER.format(currentDate)+" "+String.format("GMT%d:%02d",hour1,minutes1);  //Date in target timezone
	      
       //Format date time - optional
     //  System.out.println(dateFormatter.format(currentISTime));      
     //  System.out.println(dateFormatter.format(currentETime));
       
       /**
        * get currency of default locale
        */
       Double currency =new Double(765432345678.87);
     
         /**
          * get current currency of given locale
          */
         Currency currentCurrency=Currency.getInstance(currentLocale);
         /**
          * get format of currency on given locale
          */
         NumberFormat formatter=NumberFormat.getCurrencyInstance(currentLocale);
         String formattedCurrency=formatter.format(currency);
       //  System.out.println("currency : "+formattedCurrency);
         
         /**
          * format of any number by Locale based
          */
         NumberFormat formattter1=NumberFormat.getNumberInstance(currentLocale);
         String number=formattter1.format(currency);
         
         //**********************************				   					   **********************************
      	 //**********************************	 Phone Number Format			   **********************************
         //**********************************				   					   **********************************
        
        
         PhoneNumber swissNumberProto=null;
         //String swissNumberStr = "044 668 18 00";
         String swissNumberStr = "870 079 30 42";
         PhoneNumberUtil phoneUtil = PhoneNumberUtil.getInstance();
         try {
           swissNumberProto = phoneUtil.parse(swissNumberStr, currentCountryCode);
         } catch (NumberParseException e) {
           System.err.println("NumberParseException was thrown: " + e.toString());
         }
         
         boolean isValid = phoneUtil.isValidNumber(swissNumberProto); // returns true
         /**
          *  Produces "+41 44 668 18 00"
          */
         String internationalLevel=phoneUtil.format(swissNumberProto, PhoneNumberFormat.INTERNATIONAL);
        // System.out.println("Phone Number for "+currentLocale.getDisplayCountry()+" at International Level is : "+internationalLevel);
         /**
          * Produces "044 668 18 00"
          */
         String nationalLevel=phoneUtil.format(swissNumberProto, PhoneNumberFormat.NATIONAL);
         //System.out.println("Phone Number for "+currentLocale.getDisplayCountry()+" at National Level is : "+nationalLevel);
         
         /**
          * Produces "+41446681800"
          */
         String E164Level=phoneUtil.format(swissNumberProto, PhoneNumberFormat.E164);
         //System.out.println("Phone Number for "+currentLocale.getDisplayCountry()+" at E164 Level is : "+E164Level);
  
	   model.addAttribute( "str1", msgSrc.getMessage("str1", null, loc) );
	   model.addAttribute( "str2", msgSrc.getMessage("str2", null, loc) );
	   model.addAttribute( "currentCountry",new java.lang.String(zoneIdFrom+" : "+dateFormatter.format(currentISTime)));
	   model.addAttribute( "finalCountry",new java.lang.String(zoneIdTo+" : "+dateFormatter.format(currentETime)));
	   model.addAttribute("str3",new java.lang.String(zoneIdFrom+" : "+str1));
	   model.addAttribute("str4",new java.lang.String(zoneIdTo+" : "+str2));
	   model.addAttribute("currency",new java.lang.String("Currency of "+currentLocale.getDisplayName()+" is : "+formattedCurrency+" "+currentCurrency.getDisplayName()));
	   model.addAttribute("number",new java.lang.String("Number representation for "+currentLocale.getDisplayCountry()+" is : "+number));
	   model.addAttribute("PhoneNumber",new java.lang.String("Phone Number for "+currentLocale.getDisplayCountry()+" at <br/>International Level : "+internationalLevel+"<br/> National Level : "+nationalLevel+"<br/>E164 Level : "+E164Level));
	   
	   return "home";
	}
}
