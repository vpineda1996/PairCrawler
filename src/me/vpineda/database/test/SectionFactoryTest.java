package me.vpineda.database.test;

import me.vpineda.database.SectionFactory;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

/**
 * Created by vpineda1996 on 2015-06-01.
 */
public class SectionFactoryTest {
    String grdResponse, grdResponse2;

    @Before
    public void setUp() throws Exception {
        setupGradesResponse();
    }

    private void setupGradesResponse() throws Exception{
        grdResponse = "\n" +
                " \n" +
                "\n" +
                "\n" +
                "\n" +
                "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">\n" +
                "<html xmlns=\"http://www.w3.org/1999/xhtml\">\n" +
                "\n" +
                "<head>\n" +
                "\n" +
                "<title>Grades Distribution</title>\n" +
                "\n" +
                "<script type=\"text/javascript\">\n" +
                "// Turns MegaMenu on or off - See $(document).ready() in main.js\n" +
                "var UbcMegaMenu = true;\n" +
                "\n" +
                "// Turns Place of Mind Effect on or off - See $(document).ready() & Ubc.megaMenu.init() in main.js\n" +
                "var UbcPlaceOfMind = false;\n" +
                "\n" +
                "// Turns MainMenu drop-downs on or off - See $(document).ready() & Ubc.megaMenu.init() in main.js\n" +
                "var UbcMainMenuDropDown = false;\n" +
                "\n" +
                "// Appends URL string after http://www.aplaceofmind.ubc.ca/ in the Learn More button in the Place of Mind MegaMenu. \n" +
                "// Use an emptry string - i.e. \"\" - for the link to go directly to http://www.aplaceofmind.ubc.ca/\n" +
                "var UbcPlaceOfMindLink = \"\";\n" +
                "\n" +
                "// Sets the RSS feed address for the A Place of Mind effect -  See method Ubc.placeOfMind.loadRss() in main.js\n" +
                "var UbcPlaceOfMindRSS = \"\";\n" +
                "\n" +
                "// Set Search Label - If in doubt, use your unit's name.  i.e. Human Resources, Arts, President's Office, etc.\n" +
                "// See Ubc.search.init() in main.js\n" +
                "var SubUnitLabel = \"Planning and Institutional Research\";\n" +
                "\n" +
                "// Set Search Domain - Specify the domain for search results.  If in doubt, use *.yourdomain.ubc.ca - i.e. *.hr.ubc.ca, *.arts.ubc.ca, *.president.ubc.ca\n" +
                "// See Ubc.search.init() in main.js\n" +
                "var SearchSite = \"http://www.pair.ubc.ca\";\n" +
                "</script>\n" +
                "\n" +
                "<link rel=\"icon\"\n" +
                "\thref=\"/reports/images/favicon.ico\"\n" +
                "\ttype=\"image/x-icon\" />\n" +
                "\t\n" +
                "<link rel=\"shortcut icon\"\n" +
                "\thref=\"/reports/images/favicon.ico\"\n" +
                "\ttype=\"image/x-icon\" />\n" +
                "\n" +
                "<style type=\"text/css\">\n" +
                "body.textoption.option5 #UbcHeader a#UbcMindLink,body.textoption.option6 #UbcHeader a#UbcMindLink\n" +
                "{\n" +
                "\tbackground-color: #002859;\n" +
                "}\n" +
                "</style>\n" +
                "\n" +
                "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=iso-8859-1\" />\n" +
                "<meta http-equiv=\"Cache-Control\" content=\"no-store\"/>\n" +
                "<meta http-equiv=\"Expires\" content=\"-1\"/>\n" +
                "<meta http-equiv=\"Pragma\" content=\"no-cache\"/>\n" +
                "\n" +
                "<!-- Mimic Internet Explorer -->\n" +
                "<meta http-equiv=\"X-UA-Compatible\" content=\"IE=8\"/>\n" +
                "\n" +
                "<script type=\"text/javascript\" src=\"/reports/dwr/interface/sisservice.js\"></script>\n" +
                "<script type=\"text/javascript\" src=\"/reports/dwr/engine.js\"></script>\n" +
                "<script type=\"text/javascript\" src=\"/reports/dwr/util.js\"></script>\n" +
                "\t\n" +
                "<link rel='stylesheet' id='ubc_clf_clf-required-fixedwidth-css'\n" +
                "\thref='/reports/_ubc_clf/css/clf-required-fixedwidth.css'\n" +
                "\ttype='text/css' media='screen' />\n" +
                "\t\n" +
                "<link rel=\"stylesheet\"\n" +
                "\thref=\"/reports/css/style.css\" type=\"text/css\"\n" +
                "\tmedia=\"screen\" />\n" +
                "\t\n" +
                "<!--[if lte IE 7]>\n" +
                "<link href=\"/reports/_ubc_clf/css/ie.css\" type=\"text/css\" media=\"screen\" rel=\"Stylesheet\" />\n" +
                "<![endif]-->\n" +
                "\t\n" +
                "<script type=\"text/javascript\" src=\"https://www.google.com/jsapi\"></script>\n" +
                "\t\n" +
                "<script type='text/javascript'\n" +
                "\tsrc='/reports/scripts/jquery-1.4.2.min.js'></script>\n" +
                "\t\n" +
                "<script type='text/javascript'\n" +
                "\tsrc='/reports/scripts/subpages-navigation.js'></script>\n" +
                "\t\n" +
                "<script type='text/javascript'\n" +
                "\tsrc='/reports/_ubc_clf/js/main.js'></script>\n" +
                "\n" +
                "<script type=\"text/javascript\" src=\"/reports/yuibuild2.3.1/yahoo/yahoo.js\"></script>\n" +
                "<script type=\"text/javascript\" src=\"/reports/yuibuild2.3.1/event/event.js\" ></script>\n" +
                "<script type=\"text/javascript\" src=\"/reports/yuibuild2.3.1/dom/dom.js\" ></script>\n" +
                "<script type=\"text/javascript\" src=\"/reports/yuibuild2.3.1/calendar/calendar.js\"></script>\n" +
                "\n" +
                "<script type=\"text/javascript\" src=\"/reports/empty.txt\"></script>\n" +
                "<script type=\"text/javascript\" src=\"/reports/empty.txt\"></script>\n" +
                "<script type=\"text/javascript\" src=\"/reports/empty.txt\"></script>\n" +
                "<script type=\"text/javascript\" src=\"/reports/empty.txt\"></script>\n" +
                "<script type=\"text/javascript\" src=\"/reports/empty.txt\"></script>\n" +
                "\n" +
                "<script type=\"text/javascript\">\n" +
                "\tfunction cursor_wait() \n" +
                "\t{\n" +
                "\t\tdocument.body.style.cursor = 'wait';\n" +
                "\t}\n" +
                "\t\n" +
                "\tfunction cursor_clear() \n" +
                "\t{\n" +
                "\t\tdocument.body.style.cursor = 'default';\n" +
                "\t}\n" +
                "\n" +
                "\tString.prototype.trim = function() \n" +
                "\t{\n" +
                "\t\treturn this.replace(/^\\s+|\\s+$/g,\"\");\n" +
                "\t}\n" +
                "\tString.prototype.ltrim = function() \n" +
                "\t{\n" +
                "\t\treturn this.replace(/^\\s+/,\"\");\n" +
                "\t}\n" +
                "\tString.prototype.rtrim = function() \n" +
                "\t{\n" +
                "\t\treturn this.replace(/\\s+$/,\"\");\n" +
                "\t}\t\n" +
                "\t\n" +
                "\tvar visible, hidden;\n" +
                "\n" +
                "\tif ( document.layers )\n" +
                "\t{\n" +
                "\t  visible = 'show';\n" +
                "\t  hidden = 'hide';\n" +
                "\t}\n" +
                "\telse if ( document.all )\n" +
                "\t{\n" +
                "\t  visible = 'visible';\n" +
                "\t  hidden = 'hidden';\n" +
                "\t}\n" +
                "\telse if ( document.getElementById )\n" +
                "\t{\n" +
                "\t  visible = 'visible';\n" +
                "\t  hidden = 'hidden';\n" +
                "\t}\n" +
                "\n" +
                "\tfunction showmenu( elmnt, cell )\n" +
                "\t{\n" +
                "\n" +
                "\t  if ( document.layers )\n" +
                "\t  {\n" +
                "\t\tdaElmnt = document.layers[elmnt];\n" +
                "\t\tdaCell = document.layers[ cell ];\n" +
                "\t  }\n" +
                "\t  else if ( document.all )\n" +
                "\t  {\n" +
                "\t\tdaElmnt = document.all( elmnt );\n" +
                "\t\tdaCell = document.all( cell );\n" +
                "\t  }\n" +
                "\t  else if ( document.getElementById )\n" +
                "\t  {\n" +
                "\t\tdaElmnt = document.getElementById( elmnt );\n" +
                "\t\tdaCell = document.getElementById( cell );\n" +
                "\t\tp = daCell;\n" +
                "\t\toffsetleft = 0;\n" +
                "\t\toffsettop = 0;\n" +
                "\t\twhile ( p != null )\n" +
                "\t\t{\n" +
                "\t\t\toffsetleft += p.offsetLeft;\n" +
                "\t\t\toffsettop += p.offsetTop;\n" +
                "\n" +
                "\t\t\tp = p.offsetParent;\n" +
                "\t\t}\n" +
                "\n" +
                "\t\tdaElmnt.style.left = offsetleft;\n" +
                "\n" +
                "\t\tdaElmnt.style.top = offsettop + 18;\n" +
                "\n" +
                "\t  }\n" +
                "\n" +
                "\t  daElmnt.style.visibility = visible;\n" +
                "\t}\n" +
                "\n" +
                "\tfunction hidemenu( elmnt )\n" +
                "\t{\n" +
                "\t  if (document.layers)\n" +
                "\t  {\n" +
                "\t\tdaElmnt = document.layers[elmnt];\n" +
                "\t  } \n" +
                "\t  else if ( document.all )\n" +
                "\t  {\n" +
                "\t\tdaElmnt = document.all( elmnt );\n" +
                "\t  }\n" +
                "\t  else if ( !document.layers && !document.all && document.getElementById )\n" +
                "\t  {\n" +
                "\t\tdaElmnt = document.getElementById( elmnt );\n" +
                "\t  }\n" +
                "\n" +
                "\t  daElmnt.style.visibility = 'hidden';\n" +
                "\n" +
                "\t}\n" +
                "\t\n" +
                "\tfunction expandDIV( whichElement )\n" +
                "\t{\t\t\n" +
                "\t\tvar elem, vis;\n" +
                "\t\tif( document.getElementById ) // this is the way the standards work\n" +
                "\t\t{\n" +
                "\t\t\telem = document.getElementById( whichElement );\n" +
                "\t\t}\n" +
                "\t\telse if( document.all ) // this is the way old msie versions work\n" +
                "\t\t{\n" +
                "\t\t    elem = document.all[whichElement];\n" +
                "\t\t}\n" +
                "\t\telse if( document.layers ) // this is the way nn4 works\n" +
                "\t\t{\n" +
                "\t\t  \telem = document.layers[whichElement];\n" +
                "\t\t}\n" +
                "\t\t\n" +
                "\t\tvis = elem.style;\n" +
                "\t\t\n" +
                "\t\tvis.display = 'block';\n" +
                "\t}\n" +
                "\n" +
                "\tfunction hideDIV( whichElement )\n" +
                "\t{\n" +
                "\t\tvar elem, vis;\n" +
                "\t\tif( document.getElementById ) // this is the way the standards work\n" +
                "\t\t{\n" +
                "\t\t\telem = document.getElementById( whichElement );\n" +
                "\t\t}\n" +
                "\t\telse if( document.all ) // this is the way old msie versions work\n" +
                "\t\t{\n" +
                "\t\t    elem = document.all[whichElement];\n" +
                "\t\t}\n" +
                "\t\telse if( document.layers ) // this is the way nn4 works\n" +
                "\t\t{\n" +
                "\t\t  \telem = document.layers[whichElement];\n" +
                "\t\t}\n" +
                "\t\t\n" +
                "\t\tvis = elem.style;\n" +
                "\t\t\n" +
                "\t\tvis.display = 'none';\n" +
                "\t}\t\n" +
                "\t\n" +
                "\tfunction checkAll( radioObj ) \n" +
                "\t{\n" +
                "\t\tif ( !radioObj )\n" +
                "\t\t\treturn;\n" +
                "\t\t\n" +
                "\t\tvar radioLength = radioObj.length;\n" +
                "\t\tif ( radioLength == undefined ) \n" +
                "\t\t{\n" +
                "\t\t\treturn;\n" +
                "\t\t}\n" +
                "\t\t\n" +
                "\t\tfor ( var i = 0; i < radioLength; i++ ) \n" +
                "\t\t{\n" +
                "\t\t\tradioObj[i].checked = true;\n" +
                "\t\t}\n" +
                "\t}\n" +
                "\t\n" +
                "\tfunction decheckAll( radioObj ) \n" +
                "\t{\n" +
                "\t\tif ( !radioObj )\n" +
                "\t\t\treturn;\n" +
                "\t\tvar radioLength = radioObj.length;\n" +
                "\t\tif ( radioLength == undefined ) \n" +
                "\t\t{\n" +
                "\t\t\treturn;\n" +
                "\t\t}\n" +
                "\t\t\n" +
                "\t\tfor ( var i = 0; i < radioLength; i++ ) \n" +
                "\t\t{\n" +
                "\t\t\tradioObj[i].checked = false;\n" +
                "\t\t}\n" +
                "\t}\t\n" +
                "\t\t\n" +
                "\tfunction getCheckedValue( radioObj ) \n" +
                "\t{\n" +
                "\t\tif( !radioObj )\n" +
                "\t\t\treturn \"\";\n" +
                "\t\tvar radioLength = radioObj.length;\n" +
                "\t\tif ( radioLength == undefined )\n" +
                "\t\t\tif( radioObj.checked )\n" +
                "\t\t\t\treturn radioObj.value;\n" +
                "\t\t\telse\n" +
                "\t\t\t\treturn \"\";\n" +
                "\t\tfor ( var i = 0; i < radioLength; i++ ) {\n" +
                "\t\t\tif ( radioObj[i].checked ) {\n" +
                "\t\t\t\treturn radioObj[i].value;\n" +
                "\t\t\t}\n" +
                "\t\t}\n" +
                "\t\treturn \"\";\n" +
                "\t}\n" +
                "\t\n" +
                "\tfunction setCheckedValue( radioObj, newValue ) \n" +
                "\t{\n" +
                "\t\tif( !radioObj )\n" +
                "\t\t\treturn;\n" +
                "\t\tvar radioLength = radioObj.length;\n" +
                "\t\tif( radioLength == undefined ) {\n" +
                "\t\t\tradioObj.checked = ( radioObj.value == newValue.toString() );\n" +
                "\t\t\treturn;\n" +
                "\t\t}\n" +
                "\t\tfor( var i = 0; i < radioLength; i++ ) {\n" +
                "\t\t\tradioObj[i].checked = false;\n" +
                "\t\t\tif(radioObj[i].value == newValue.toString()) {\n" +
                "\t\t\t\tradioObj[i].checked = true;\n" +
                "\t\t\t}\n" +
                "\t\t}\n" +
                "\t}\t\n" +
                "\n" +
                "\tfunction getSelectedValues( ob ) \n" +
                "\t{ \n" +
                "\t\tselected = new Array(); \n" +
                "\t\tfor ( i = 0; i < ob.options.length; i++ ) \n" +
                "\t\t\tif ( ob.options[ i ].selected ) \n" +
                "\t\t\t\tselected.push( ob.options[ i ].value );\n" +
                "\n" +
                "\t\treturn selected;\n" +
                "\t}\n" +
                "\n" +
                "\tfunction getSelectedValue( ob ) \n" +
                "\t{ \n" +
                "\t\treturn ob.value;\n" +
                "\t}\n" +
                "\n" +
                "\tfunction getSelectValues( ob )\n" +
                "\t{\n" +
                "\t\tselected = new Array(); \n" +
                "\t\tfor ( i = 0; i < ob.options.length; i++ ) \n" +
                "\t\t\tselected.push( ob.options[ i ].value );\n" +
                "\n" +
                "\t\treturn selected;\n" +
                "\t}\n" +
                "\t\n" +
                "\tfunction setSelectedValue(listObj, itemToSelect) \n" +
                "\t{\n" +
                "\t\tif ( !listObj )\n" +
                "\t\t\treturn false;;\n" +
                "\t\t\t\n" +
                "\t    // Loop through all the items\n" +
                "\t    for ( iLoop = 0; iLoop< listObj.options.length; iLoop++ )\n" +
                "\t    {\n" +
                "\t    \tif ( listObj.options[ iLoop ].value == itemToSelect )\n" +
                "\t      \t{\n" +
                "\t        \t// Item is found. Set its selected property, and exit the loop\n" +
                "\t        \tlistObj.options[ iLoop ].selected = true;\n" +
                "\t        \treturn true;;\n" +
                "\t      \t}\n" +
                "\t    }\n" +
                "\t    \n" +
                "\t    return false;\n" +
                "\t}\t\n" +
                "\n" +
                "\tfunction setSelectedValues( listObj, items )\n" +
                "\t{\n" +
                "\t\tif ( !listObj )\n" +
                "\t\t\treturn;\n" +
                "\t\t\t\n" +
                "\t    // Loop through all the items\n" +
                "\t    for ( i = 0; i < items.length; i++ )\n" +
                "\t    {\n" +
                "\t    \titemToSelect = items[ i ];\n" +
                "\t\t    for ( iLoop = 0; iLoop < listObj.options.length; iLoop++ )\n" +
                "\t\t    {\n" +
                "\t\t    \tif ( listObj.options[ iLoop ].value == itemToSelect )\n" +
                "\t\t      \t{\n" +
                "\t\t        \t// Item is found. Set its selected property, and exit the loop\n" +
                "\t\t        \tlistObj.options[ iLoop ].selected = true;\n" +
                "\t\t        \tbreak;\n" +
                "\t\t      \t}\n" +
                "\t\t    }\n" +
                "\t    }\n" +
                "\t}\n" +
                "\n" +
                "\tfunction unSelectAll(listObj) \n" +
                "\t{\n" +
                "\t\tif ( !listObj )\n" +
                "\t\t\treturn;\n" +
                "\t\t\t\n" +
                "\t    // Loop through all the items\n" +
                "\t    for ( iLoop = 0; iLoop< listObj.options.length; iLoop++ )\n" +
                "\t    {\n" +
                "\t        listObj.options[ iLoop ].selected = false;\n" +
                "\t    }\n" +
                "\t}\t\n" +
                "\n" +
                "\tfunction clearlist( listobj )\n" +
                "\t{\n" +
                "\t\tunSelectAll( listobj );\n" +
                "\t}\n" +
                "\t\n" +
                "\tfunction formatyui231( args ) \n" +
                "\t{\n" +
                "\t\tdates = args[0];\n" +
                "\t\tdate = dates[0];\n" +
                "\t\tyear = date[0], month = date[1], day = date[2];\n" +
                "\t\n" +
                "\t\tif ( month < 10 )\n" +
                "\t\t\tmonth = \"0\" + month;\n" +
                "\t\tif ( day < 10 )\n" +
                "\t\t\tday = \"0\" + day;\n" +
                "\t\t\t\n" +
                "\t\treturn year + \"-\" + month + \"-\" + day;\n" +
                "\t}     \t\t\n" +
                "</script>\n" +
                "\n" +
                "<link href=\"/reports/empty.css\" rel=\"stylesheet\" type=\"text/css\"/>\n" +
                "<link href=\"/reports/empty.css\" rel=\"stylesheet\" type=\"text/css\"/>\n" +
                "\n" +
                "<style type=\"text/css\" media=\"screen\">\n" +
                "<!--\n" +
                "@import\n" +
                "\turl(\"/reports/css/displaytag/displaytag.css\")\n" +
                "\t;\n" +
                "\n" +
                "@import\n" +
                "\turl(\"/reports/css/displaytag/alternative.css\")\n" +
                "\t;\n" +
                "\n" +
                "@import\n" +
                "\turl(\"/reports/struts/assets/calendar.css\");\n" +
                "\n" +
                "-->\n" +
                "\n" +
                "#body-container {\n" +
                "\toverflow: visible;\n" +
                "}\n" +
                "\n" +
                "#webappcontent {\n" +
                "\t/*text-align:justify;*/\n" +
                "\tmin-height: 400px;\n" +
                "\tborder:0 none;\n" +
                "\t\n" +
                "\t\n" +
                "\tdisplay:inline;\n" +
                "\tfloat:left;\n" +
                "\tmargin:0;\n" +
                "\tpadding: 5px;\n" +
                "\t/*width:980px;*/\n" +
                "\t\n" +
                "\t/*outline: #0000FF dotted thin;*/\n" +
                "}\n" +
                "\n" +
                "#webappcontent html, body, div, span, applet, object, iframe, h1, h2, h3, h4, h5, h6, p, blockquote, pre, a, abbr, acronym, address, big, cite, code, del, dfn, em, font, img, ins, kbd, q, s, samp, small, strike, sub, sup, tt, var, b, u, i, center, dl, dt, dd, ol, ul, li, fieldset, form, label, legend, table, caption, tbody, tfoot, thead, tr, th, td {\n" +
                "\tbackground:none repeat scroll 0 0 transparent;\n" +
                "\tvertical-align: top;\n" +
                "}\n" +
                "\n" +
                "#webappcontent li {\n" +
                "\tmargin-bottom:4px;\n" +
                "\tmargin-left: 4px;\n" +
                "}\n" +
                "\n" +
                ".panel {\n" +
                "\tposition: absolute;\n" +
                "\tright: 0;\n" +
                "\tdisplay: none;\n" +
                "\tbackground: #FFFFFF;\n" +
                "\t/*border:1px solid #111111;*/\n" +
                "\tborder: 0px;\n" +
                "\twidth: 250px;\n" +
                "\t/*height: auto;*/ /*padding: 30px 30px 30px 130px;*/\n" +
                "\tfilter: alpha(opacity = 85);\n" +
                "\topacity: .85;\n" +
                "\t/*height: 400px;*/\n" +
                "\toverflow: visible;\n" +
                "}\n" +
                "\n" +
                ".panel p {\n" +
                "\tmargin: 0 0 15px 0;\n" +
                "\tpadding: 0;\n" +
                "\tcolor: #cccccc;\n" +
                "}\n" +
                "\n" +
                "a.navtrigger { /*position: absolute;*/\n" +
                "\ttext-decoration: none;\n" +
                "\t/*top: 50px;*/\n" +
                "\tright: 0;\n" +
                "\t/*font-size: 16px;*/ /*letter-spacing:-1px;*/\n" +
                "\t/*font-family: verdana, helvetica, arial, sans-serif;*/ /*color:#fff;*/\n" +
                "\t/*padding: 20px 40px 20px 15px;*/ /*font-weight: 700;*/\n" +
                "\t/*background:#333333 url(/reports/images/plus.gif) 85% 55% no-repeat;*/\n" +
                "\tbackground: #FFFFFF url(/reports/images/plus.gif) no-repeat;\n" +
                "\tpadding: 0px 0px 0px 20px;\n" +
                "\t/*border:1px solid #444444;*/\n" +
                "\tdisplay: block;\n" +
                "}\n" +
                "\n" +
                "a.navtrigger:hover { /*position: absolute;*/\n" +
                "\ttext-decoration: none;\n" +
                "\t/*top: 50px;*/\n" +
                "\tright: 0;\n" +
                "\t/*font-size: 16px;*/ /*letter-spacing:-1px;*/\n" +
                "\t/*font-family: verdana, helvetica, arial, sans-serif;*/ /*color:#fff;*/\n" +
                "\t/*padding: 20px 40px 20px 15px;*/ /*font-weight: 700;*/\n" +
                "\t/*background:#222222 url(/reports/images/plus.gif) 85% 55% no-repeat;*/\n" +
                "\tbackground: #FFFFFF url(/reports/images/plus.gif) no-repeat;\n" +
                "\tpadding: 0px 0px 0px 20px;\n" +
                "\t/*border:1px solid #444444;*/\n" +
                "\tdisplay: block;\n" +
                "}\n" +
                "\n" +
                "a.active.navtrigger {\n" +
                "\t/*background:#222222 url(/reports/images/minus.gif) 85% 55% no-repeat;*/\n" +
                "\tbackground: #FFFFFF url(/reports/images/minus.gif) no-repeat;\n" +
                "\tpadding: 0px 0px 0px 20px;\n" +
                "}\n" +
                "</style>\n" +
                "\n" +
                "<!-- \n" +
                "<script type=\"text/javascript\" src=\"http://jqueryjs.googlecode.com/files/jquery-1.3.2.js\"></script>\n" +
                " -->\t\n" +
                "\t\n" +
                "<script type=\"text/javascript\">\n" +
                "$(document).ready(function(){\n" +
                "\t$(\".navtrigger\").click(function(){\n" +
                "\t\t$(\".panel\").toggle(\"fast\");\n" +
                "\t\t$(this).toggleClass(\"active\");\n" +
                "\t\treturn false;\n" +
                "\t});\n" +
                "});\n" +
                "</script>\n" +
                "\n" +
                "\n" +
                "</head>\n" +
                "\n" +
                "<body\n" +
                "\tclass=\"ltr y2010 m04 d15 h05 thursday not-logged-in home front-page singular page page-3 page-template page-template-default page-author-nrogic windows firefox firefox-3 primary-active secondary-inactive subsidiary-inactive option1 textoption\">\n" +
                "\n" +
                "<!-- BEGIN: UBC CLF HEADER -->\n" +
                "<div id=\"UbcHeaderWrapper\"><!-- BEGIN: UBC CLF GLOBAL UTILITY HEADER -->\n" +
                "<div id=\"UbcToolBarWrapper\">\n" +
                "<div id=\"UbcToolBar\" class=\"UbcContainer\">\n" +
                "<ul id=\"UbcToolNav\" style=\"list-style: none outside none;\">\n" +
                "\t<li><a id=\"UbcCampusLinks\" href=\"http://www.ubc.ca/campuses/\">Campuses</a></li>\n" +
                "\t<li><a id=\"UbcDirectLinks\" href=\"http://www.ubc.ca/directories/\">UBC\n" +
                "\tDirectories</a></li>\n" +
                "\t<li><a id=\"UbcQuickLinks\" href=\"http://www.ubc.ca/quicklinks/\">UBC\n" +
                "\tQuick Links</a></li>\n" +
                "\t<li class=\"UbcForm\">\n" +
                "\t<form id=\"UbcSearchForm\" action=\"http://www.ubc.ca/search/\"\n" +
                "\t\tmethod=\"get\">\n" +
                "\t<input type=\"text\" name=\"q\" value=\"\" class=\"UbcSearchField\" />\n" +
                "\t<input type=\"image\"\n" +
                "\t\tsrc=\"/reports/_ubc_clf/img/header/spacer.gif\"\n" +
                "\t\tclass=\"UbcSearchBtn\" value=\"Search\" alt=\"Search\" />\n" +
                "\t</form>\n" +
                "\t</li>\n" +
                "</ul>\n" +
                "\n" +
                "</div>\n" +
                "<!-- End UbcToolBar UbcContainer --></div>\n" +
                "<!-- End UbcToolBarWrapper -->\n" +
                "<div id=\"UbcMegaMenuesWrapper\" class=\"UbcContainer\">\n" +
                "<div id=\"UbcMegaMenues\" class=\"UbcContainer\"><a href=\"#\"\n" +
                "\tclass=\"UbcCloseBtn\">[X] close</a></div>\n" +
                "<!-- End UbcMegaMenues UbcContainer --></div>\n" +
                "<!-- End UbcMegaMenuesWrapper UbcContainer --> <!-- END: UBC CLF GLOBAL UTILITY HEADER -->\n" +
                "<!-- BEGIN: UBC CLF VISUAL IDENTITY HEADER -->\n" +
                "<ul id=\"UbcHeader\" class=\"UbcContainer\" style=\"list-style: none outside none;\">\n" +
                "\n" +
                "\t<li>\n" +
                "\t<h1 id=\"UbcLogo\"><a href=\"http://www.ubc.ca/\">The University\n" +
                "\tof British Columbia</a></h1>\n" +
                "\t</li>\n" +
                "\t<li class=\"UbcMindLink\"><a href=\"http://www.aplaceofmind.ubc.ca/\"\n" +
                "\t\tid=\"UbcMindLink\">a place of mind</a></li>\n" +
                "\t<li id=\"UbcHeaderLine\"><a href=\"http://www.ubc.ca\"\n" +
                "\t\tid=\"UbcHeaderLink\"><span>The University of British Columbia</span></a></li>\n" +
                "\t<li id=\"UbcSubUnitLine\"><a href=\"http://www.pair.ubc.ca\"\n" +
                "\t\tid=\"UbcSubUnitLink\"><span>Planning &amp; Institutional Research</span></a></li>\n" +
                "</ul>\n" +
                "\n" +
                "</div>\n" +
                "<!-- End UbcHeaderWrapper -->\n" +
                "\n" +
                "\n" +
                "<div id=\"body-container\">\n" +
                "\n" +
                "<div id=\"header-container\">\n" +
                "\n" +
                "<div id=\"header\"></div>\n" +
                "<!-- #header --></div>\n" +
                "<!-- #header-container -->\n" +
                "\n" +
                "<div id=\"main-nav\">\n" +
                "<ul class=\"main-menu\">\t\t\n" +
                "\t<li class=\"navtrigger page-list-1 page_item page-item-1\"><a\n" +
                "\t\thref=\"#\" \n" +
                "\t\ttitle=\"Navigation\">Side-bar<br/>navigation</a>\n" +
                "\t</li>\n" +
                "\t\n" +
                "\t<li class=\"page-list-1 page_item page-item-3 current_page_item\"><a\n" +
                "\t\thref=\"/reports\" title=\"Home\">Home</a>\n" +
                "\t</li>\n" +
                "\t\t\n" +
                "\t\n" +
                "\t<li class=\"page-list-1 page_item page-item-3 current_page_item\"><a\thref=\"/reports/logout.action\">Logout</a></li>\n" +
                "\t\t\n" +
                "\n" +
                "\t\n" +
                "<!-- \n" +
                "\t\n" +
                "-->\n" +
                "\n" +
                "\t\n" +
                "\t\n" +
                "\t\n" +
                "\t\n" +
                "\t<!-- \n" +
                "\t\n" +
                "\t<li class=\"page-list-1 page_item page-item-77\"><a\n" +
                "\t\thref=\"http://www.ombudsoffice.ubc.ca/\"\n" +
                "\t\ttitle=\"Office of Ombudsperson for Students\">Ombudsperson<br/>for Students</a>\n" +
                "\t<ul>\n" +
                "\t\t\n" +
                "\t\t<li class=\"page-list-1 page_item page-item-35\">\n" +
                "\t\t\t<a href=\"/reports/forms_request.action?formname=ombudstudent20090727\">Student Online Request for Assistance</a>\n" +
                "\t\t</li>\n" +
                "\t\t\n" +
                "\t\t\n" +
                "\t\t\n" +
                "\t</ul>\t\t\n" +
                "\t</li>\n" +
                "\t\n" +
                "\t-->\n" +
                "\t\n" +
                "\t\t\t\t\n" +
                "\t<li class=\"page-list-1 page_item page-item-61\"><a\n" +
                "\t\thref=\"http://www.students.ubc.ca/\" title=\"SIS Reports\">SIS Reports</a>\n" +
                "\t<ul>\n" +
                "\t\t\n" +
                "\n" +
                "\t\t<li class=\"page-list-1 page_item page-item-41\"><a href=\"/reports/autoreport_request.action?reportname=cs\" title=\"Classrooms and Space\">Classrooms and Space</a></li>\n" +
                "\t\t\n" +
                "\t\t<li class=\"page-list-1 page_item page-item-35\"><a href=\"/reports/crsdist_request.action\">Course Distribution Report</a></li>\n" +
                "\t\t<li class=\"page-list-1 page_item page-item-41\"><a href=\"/reports/enrl_request.action\">Course Enrollment Report</a></li>\n" +
                "\t\t<li class=\"page-list-1 page_item page-item-35\"><a href=\"/reports/degreeprofile_request.action\">Degree Profile Report</a></li>\n" +
                "\t\t\n" +
                "\t\t<li class=\"page-list-1 page_item page-item-41\"><a href=\"/reports/gradesdist_request.action\">Grades Distribution Report</a></li>\t\t\t\t\n" +
                "\t\t\n" +
                "\t\t\n" +
                "\t</ul>\n" +
                "\t</li>\t\n" +
                "\t\n" +
                "\t\t\n" +
                "</ul>\n" +
                "</div>\n" +
                "\n" +
                "<div id=\"container\">\n" +
                "\n" +
                "<div id=\"webappcontent\">\n" +
                " \n" +
                "\n" +
                "\n" +
                " \n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "<h2>Grades Distribution</h2>\n" +
                "\n" +
                "\n" +
                "\n" +
                "<form id=\"gradesdist_runreport\" name=\"reportform\" action=\"/reports/gradesdist_runreport.action\" method=\"post\">\n" +
                "\n" +
                "\t<input type=\"hidden\" name=\"struts.token.name\" value=\"token\" />\n" +
                "<input type=\"hidden\" name=\"token\" value=\"QGHFIBCPD9TGNMYP0C10OWS4R6XR3E45\" />\n" +
                "\t\n" +
                "\t<input type=\"hidden\" name=\"faculty\" value=\"\" id=\"gradesdist_runreport_faculty\"/>\n" +
                "\t<input type=\"hidden\" name=\"dept\" value=\"\" id=\"gradesdist_runreport_dept\"/>\n" +
                "\t\n" +
                "\t\t\n" +
                "\t<div id=\"wwgrp_gradesdist_runreport_reporttype\" class=\"wwgrp\">\n" +
                "<span id=\"wwlbl_gradesdist_runreport_reporttype\" class=\"wwlbl\">\n" +
                "<label for=\"gradesdist_runreport_reporttype\" class=\"label\">        Report type:\n" +
                "</label></span> <span id=\"wwctrl_gradesdist_runreport_reporttype\" class=\"wwctrl\">\n" +
                "    \n" +
                "<input type=\"radio\" name=\"reporttype\" id=\"gradesdist_runreport_reporttypeSECTION\" checked=\"checked\" value=\"SECTION\" onchange=\"showform();\"/><label for=\"gradesdist_runreport_reporttypeSECTION\">Specific section<br/></label>\n" +
                "<input type=\"radio\" name=\"reporttype\" id=\"gradesdist_runreport_reporttypeCOURSE\" value=\"COURSE\" onchange=\"showform();\"/><label for=\"gradesdist_runreport_reporttypeCOURSE\">Specific course<br/></label>\n" +
                "<input type=\"radio\" name=\"reporttype\" id=\"gradesdist_runreport_reporttypeSUBJECT\" value=\"SUBJECT\" onchange=\"showform();\"/><label for=\"gradesdist_runreport_reporttypeSUBJECT\">Specific subject<br/></label>\n" +
                "</span> </div>\n" +
                "\t\n" +
                "\t\n" +
                "\t<br/><br/>\t\n" +
                "\t\n" +
                "\t<div id=\"d_admin\" class=\"hiddentext\">\n" +
                "\t<div id=\"wwgrp_stud_no\" class=\"wwgrp\">\n" +
                "<span id=\"wwlbl_stud_no\" class=\"wwlbl\">\n" +
                "<label for=\"stud_no\" class=\"label\">        Student #:\n" +
                "</label></span> <span id=\"wwctrl_stud_no\" class=\"wwctrl\">\n" +
                "    \n" +
                "<input type=\"text\" name=\"stud_no\" size=\"10\" maxlength=\"8\" value=\"\" id=\"stud_no\" onfocus=\"clearGradesYears()\"/></span> </div>\t\n" +
                "\t\t\n" +
                "\t<br/>\n" +
                "\t<input type=\"button\" value=\"Refresh Year/Sessions\" onclick=\"getStudentGradesYears();\"/>\t\t\n" +
                "\t<br/><br/>\n" +
                "\t</div>\n" +
                "\t\n" +
                "\t<div id=\"d_campus\" class=\"hiddentext\">\n" +
                "\t\n" +
                "\t<div id=\"wwgrp_gradesdist_runreport_campus\" class=\"wwgrp\">\n" +
                "<span id=\"wwlbl_gradesdist_runreport_campus\" class=\"wwlbl\">\n" +
                "<label for=\"gradesdist_runreport_campus\" class=\"label\">        Campus:\n" +
                "</label></span> <span id=\"wwctrl_gradesdist_runreport_campus\" class=\"wwctrl\">\n" +
                "    \n" +
                "<select name=\"campus\" id=\"gradesdist_runreport_campus\" onchange=\"getYears();\" required=\"true\">\n" +
                "    <option value=\"UBC\" selected=\"selected\">UBC Vancouver</option>\n" +
                "    <option value=\"UBCO\">UBC Okanagan</option>\n" +
                "\n" +
                "\n" +
                "</select>\n" +
                "\n" +
                "</span> </div>\n" +
                "\t</div>\n" +
                "\t\n" +
                "\t\n" +
                "\t<div id=\"wwgrp_yearsessionlist\" class=\"wwgrp\">\n" +
                "<span id=\"wwlbl_yearsessionlist\" class=\"wwlbl\">\n" +
                "<label for=\"yearsessionlist\" class=\"label\">        Year/Session:\n" +
                "</label></span> <span id=\"wwctrl_yearsessionlist\" class=\"wwctrl\">\n" +
                "    \n" +
                "<select name=\"yearsession\" id=\"yearsessionlist\" onchange=\"getTerms();\" required=\"true\">\n" +
                "    <option value=\"\"></option>\n" +
                "\n" +
                "\n" +
                "</select>\n" +
                "\n" +
                "</span> </div>\t\n" +
                "\t\n" +
                "\t<div id=\"d_term\" class=\"hiddentext\">\n" +
                "\t\n" +
                "\t<div id=\"wwgrp_termlist\" class=\"wwgrp\">\n" +
                "<span id=\"wwlbl_termlist\" class=\"wwlbl\">\n" +
                "<label for=\"termlist\" class=\"label\">        Term:\n" +
                "</label></span> <span id=\"wwctrl_termlist\" class=\"wwctrl\">\n" +
                "    \n" +
                "<select name=\"term\" id=\"termlist\" onchange=\"getSubjects();\" required=\"true\">\n" +
                "    <option value=\"\"></option>\n" +
                "\n" +
                "\n" +
                "</select>\n" +
                "\n" +
                "</span> </div>\t\t\n" +
                "\t</div>\t\t\n" +
                "\t\n" +
                "\t<div id=\"d_subject\" class=\"hiddentext\">\n" +
                "\t\n" +
                "\t<div id=\"wwgrp_subjectlist\" class=\"wwgrp\">\n" +
                "<span id=\"wwlbl_subjectlist\" class=\"wwlbl\">\n" +
                "<label for=\"subjectlist\" class=\"label\">        Course subject:\n" +
                "</label></span> <span id=\"wwctrl_subjectlist\" class=\"wwctrl\">\n" +
                "    \n" +
                "<select name=\"subject\" id=\"subjectlist\" onchange=\"getCourses();\" required=\"true\">\n" +
                "    <option value=\"\"></option>\n" +
                "\n" +
                "\n" +
                "</select>\n" +
                "\n" +
                "</span> </div>\t\t\n" +
                "\t</div>\n" +
                "\t\t\t\n" +
                "\t<div id=\"d_course\" class=\"hiddentext\">\n" +
                "\t\n" +
                "\t<div id=\"wwgrp_courselist\" class=\"wwgrp\">\n" +
                "<span id=\"wwlbl_courselist\" class=\"wwlbl\">\n" +
                "<label for=\"courselist\" class=\"label\">        Course #:\n" +
                "</label></span> <span id=\"wwctrl_courselist\" class=\"wwctrl\">\n" +
                "    \n" +
                "<select name=\"course\" id=\"courselist\" onchange=\"getDetails();\">\n" +
                "    <option value=\"\"></option>\n" +
                "\n" +
                "\n" +
                "</select>\n" +
                "\n" +
                "</span> </div>\t\n" +
                "\t\n" +
                "\t\n" +
                "\t<div id=\"wwgrp_detaillist\" class=\"wwgrp\">\n" +
                "<span id=\"wwlbl_detaillist\" class=\"wwlbl\">\n" +
                "<label for=\"detaillist\" class=\"label\">        Detail:\n" +
                "</label></span> <span id=\"wwctrl_detaillist\" class=\"wwctrl\">\n" +
                "    \n" +
                "<select name=\"detail\" id=\"detaillist\" onchange=\"getSections();\">\n" +
                "    <option value=\"\"></option>\n" +
                "\n" +
                "\n" +
                "</select>\n" +
                "\n" +
                "</span> </div>\t\t\n" +
                "\t</div>\n" +
                "\t\n" +
                "\t<div id=\"d_section\" class=\"hiddentext\">\n" +
                "\t\n" +
                "\t<div id=\"wwgrp_sectionlist\" class=\"wwgrp\">\n" +
                "<span id=\"wwlbl_sectionlist\" class=\"wwlbl\">\n" +
                "<label for=\"sectionlist\" class=\"label\">        Section #:\n" +
                "</label></span> <span id=\"wwctrl_sectionlist\" class=\"wwctrl\">\n" +
                "    \n" +
                "<select name=\"section\" id=\"sectionlist\" onchange=\"\">\n" +
                "    <option value=\"\"></option>\n" +
                "\n" +
                "\n" +
                "</select>\n" +
                "\n" +
                "</span> </div>\t\n" +
                "\t</div>\t\n" +
                "\t\n" +
                "\t<div id=\"d_faculty\" class=\"hiddentext\">\n" +
                "\t<div id=\"wwgrp_facultylist\" class=\"wwgrp\">\n" +
                "<span id=\"wwlbl_facultylist\" class=\"wwlbl\">\n" +
                "<label for=\"facultylist\" class=\"label\">        Faculty:\n" +
                "</label></span> <span id=\"wwctrl_facultylist\" class=\"wwctrl\">\n" +
                "    \n" +
                "<select name=\"facultylist\" id=\"facultylist\" onchange=\"document.reportform.faculty.value=document.reportform.facultylist.value;getDepts();\">\n" +
                "    <option value=\"\"></option>\n" +
                "\n" +
                "\n" +
                "</select>\n" +
                "\n" +
                "</span> </div>\n" +
                "\t</div>\n" +
                "\t\t\n" +
                "\t<div id=\"d_dept\" class=\"hiddentext\">\n" +
                "\t<div id=\"wwgrp_deptlist\" class=\"wwgrp\">\n" +
                "<span id=\"wwlbl_deptlist\" class=\"wwlbl\">\n" +
                "<label for=\"deptlist\" class=\"label\">        Department:\n" +
                "</label></span> <span id=\"wwctrl_deptlist\" class=\"wwctrl\">\n" +
                "    \n" +
                "<select name=\"deptlist\" id=\"deptlist\" onchange=\"document.reportform.dept.value=document.reportform.deptlist.value;\">\n" +
                "    <option value=\"\"></option>\n" +
                "\n" +
                "\n" +
                "</select>\n" +
                "\n" +
                "</span> </div>\n" +
                "\t</div>\n" +
                "\t\n" +
                "\t<div id=\"d_email\" class=\"hiddentext\">\n" +
                "\t<br/><br/>\n" +
                "\t<p>\n" +
                "\tData extraction and processing can take a long time. Enter an email address. We will send you the results.\n" +
                "\t</p>\n" +
                "\t\n" +
                "\t<div id=\"wwgrp_email\" class=\"wwgrp\">\n" +
                "<span id=\"wwlbl_email\" class=\"wwlbl\">\n" +
                "<label for=\"email\" class=\"label\">        E-mail:\n" +
                "</label></span> <span id=\"wwctrl_email\" class=\"wwctrl\">\n" +
                "    \n" +
                "<input type=\"text\" name=\"email\" size=\"50\" maxlength=\"100\" value=\"\" id=\"email\"/></span> </div>\n" +
                "\t\n" +
                "\t<div id=\"wwgrp_gradesdist_runreport_format\" class=\"wwgrp\">\n" +
                "<span id=\"wwlbl_gradesdist_runreport_format\" class=\"wwlbl\">\n" +
                "<label for=\"gradesdist_runreport_format\" class=\"label\">        Format:\n" +
                "</label></span> <span id=\"wwctrl_gradesdist_runreport_format\" class=\"wwctrl\">\n" +
                "    \n" +
                "<input type=\"radio\" name=\"format\" id=\"gradesdist_runreport_formatCSV\" value=\"CSV\"/><label for=\"gradesdist_runreport_formatCSV\">CSV</label>\n" +
                "<input type=\"radio\" name=\"format\" id=\"gradesdist_runreport_formatHTML\" checked=\"checked\" value=\"HTML\"/><label for=\"gradesdist_runreport_formatHTML\">HTML</label>\n" +
                "</span> </div>\n" +
                "\n" +
                "\t</div>\n" +
                "\n" +
                "\t<br/><br/>\n" +
                "\t<img src=\"/reports/images/captcha.jpg\" border=\"0\" />\n" +
                "\t\n" +
                "\t<div id=\"wwgrp_txtcaptchal\" class=\"wwgrp\">\n" +
                "<span id=\"wwlbl_txtcaptchal\" class=\"wwlbl\">\n" +
                "<label for=\"txtcaptchal\" class=\"label\">        Enter displayed characters:\n" +
                "</label></span> <span id=\"wwctrl_txtcaptchal\" class=\"wwctrl\">\n" +
                "    \n" +
                "<input type=\"text\" name=\"captcha\" size=\"6\" maxlength=\"6\" value=\"\" id=\"txtcaptchal\" required=\"true\"/></span> </div>\n" +
                "\t\n" +
                "\t<br/><br/>\n" +
                "\t\n" +
                "\t<div align=\"left\"    id=\"wwctrl_gradesdist_runreport_0\"><input type=\"submit\" id=\"gradesdist_runreport_0\" value=\"Submit\"/>\n" +
                "</div> <br/>\t\t\n" +
                "\n" +
                "</form>\n" +
                "\n" +
                "\n" +
                "\n" +
                " \n" +
                "\n" +
                "<script type=\"text/javascript\" src=\"/reports/dwr/interface/sisservice.js\"></script>\n" +
                "<script type=\"text/javascript\" src=\"/reports/dwr/engine.js\"></script>\n" +
                "<script type=\"text/javascript\" src=\"/reports/dwr/util.js\"></script>\n" +
                "\n" +
                "<script type=\"text/javascript\">\n" +
                "\treporttype = 'SECTION';\n" +
                "\tinit();\n" +
                "\t\n" +
                "\tfunction init() \n" +
                "\t{\t\t\t\t\n" +
                "\t\t//DWRUtil.useLoadingMessage();\t \n" +
                "\t\tshowform();\n" +
                "\t}\t\t\n" +
                "\t\n" +
                "\tfunction useLoadingMessage(message) \n" +
                "\t{\n" +
                "\t  var loadingMessage;\n" +
                "\t  if ( message ) \n" +
                "\t  \tloadingMessage = message;\n" +
                "\t  else \n" +
                "\t  \tloadingMessage = \"Loading data ... please wait\";\n" +
                "\t\n" +
                "\t  dwr.engine.setPreHook(function() {\n" +
                "\t    var disabledZone = $('disabledZone');\n" +
                "\t    if (!disabledZone) {\n" +
                "\t      disabledZone = document.createElement('div');\n" +
                "\t      disabledZone.setAttribute('id', 'disabledZone');\n" +
                "\t      disabledZone.style.position = \"absolute\";\n" +
                "\t      disabledZone.style.zIndex = \"1000\";\n" +
                "\t      disabledZone.style.left = \"0px\";\n" +
                "\t      disabledZone.style.top = \"0px\";\n" +
                "\t      disabledZone.style.width = \"100%\";\n" +
                "\t      disabledZone.style.height = \"100%\";\n" +
                "\t      document.body.appendChild(disabledZone);\n" +
                "\t      \n" +
                "\t      var messageZone = document.createElement('div');\n" +
                "\t      messageZone.setAttribute('id', 'messageZone');\n" +
                "\t      messageZone.style.position = \"absolute\";\n" +
                "\t      messageZone.style.top = \"0px\";\n" +
                "\t      messageZone.style.right = \"0px\";\n" +
                "\t      messageZone.style.background = \"red\";\n" +
                "\t      messageZone.style.color = \"white\";\n" +
                "\t      messageZone.style.fontFamily = \"Arial,Helvetica,sans-serif\";\n" +
                "\t      messageZone.style.padding = \"4px\";\n" +
                "\t      disabledZone.appendChild(messageZone);\n" +
                "\t      var text = document.createTextNode(loadingMessage);\n" +
                "\t      messageZone.appendChild(text);\n" +
                "\t    }\n" +
                "\t    else \n" +
                "\t    {\n" +
                "\t      $('messageZone').innerHTML = loadingMessage;\n" +
                "\t      disabledZone.style.visibility = 'visible';\n" +
                "\t    }\n" +
                "\t  });\n" +
                "\t\n" +
                "\t  dwr.engine.setPostHook(function() {\n" +
                "\t    $('disabledZone').style.visibility = 'hidden';\n" +
                "\t  });\n" +
                "\t}\t\t\n" +
                "\t\n" +
                "\tfunction showform()\n" +
                "\t{\n" +
                "\t\treporttype = getCheckedValue( document.reportform.reporttype );\n" +
                "\t\t\n" +
                "\t\tif ( reporttype == 'SECTION' )\n" +
                "\t\t{\n" +
                "\t\t\thideDIV( \"d_email\" );\n" +
                "\t\t\texpandDIV( \"d_campus\" );\n" +
                "\t\t\thideDIV( \"d_term\" );\n" +
                "\t\t\texpandDIV( \"d_subject\" );\n" +
                "\t\t\texpandDIV( \"d_course\" );\n" +
                "\t\t\texpandDIV( \"d_section\" );\n" +
                "\t\t\thideDIV( \"d_admin\" );\n" +
                "\t\t\thideDIV( \"d_dept\" );\n" +
                "\t\t\thideDIV( \"d_faculty\" );\n" +
                "\t\t\t\n" +
                "\t\t\tgetYears();\n" +
                "\t\t}\n" +
                "\t\t\n" +
                "\t\tif ( reporttype == 'SUBJECT' )\n" +
                "\t\t{\n" +
                "\t\t\texpandDIV( \"d_campus\" );\n" +
                "\t\t\texpandDIV( \"d_email\" );\n" +
                "\t\t\texpandDIV( \"d_subject\" );\n" +
                "\t\t\thideDIV( \"d_term\" );\n" +
                "\t\t\thideDIV( \"d_course\" );\n" +
                "\t\t\thideDIV( \"d_section\" );\n" +
                "\t\t\thideDIV( \"d_admin\" );\n" +
                "\t\t\thideDIV( \"d_dept\" );\n" +
                "\t\t\thideDIV( \"d_faculty\" );\n" +
                "\t\t\t\n" +
                "\t\t\tgetYears();\n" +
                "\t\t}\t\n" +
                "\t\t\n" +
                "\t\tif ( reporttype == 'COURSE' )\n" +
                "\t\t{\n" +
                "\t\t\texpandDIV( \"d_campus\" );\n" +
                "\t\t\texpandDIV( \"d_email\" );\n" +
                "\t\t\texpandDIV( \"d_subject\" );\n" +
                "\t\t\texpandDIV( \"d_course\" );\n" +
                "\t\t\thideDIV( \"d_section\" );\n" +
                "\t\t\thideDIV( \"d_term\" );\n" +
                "\t\t\thideDIV( \"d_admin\" );\n" +
                "\t\t\thideDIV( \"d_dept\" );\n" +
                "\t\t\thideDIV( \"d_faculty\" );\n" +
                "\t\t\t\n" +
                "\t\t\tgetYears();\n" +
                "\t\t}\t\n" +
                "\t\t\n" +
                "\t\tif ( reporttype == 'STUDENT' )\n" +
                "\t\t{\n" +
                "\t\t\thideDIV( \"d_campus\" );\n" +
                "\t\t\texpandDIV( \"d_email\" );\n" +
                "\t\t\thideDIV( \"d_subject\" );\n" +
                "\t\t\thideDIV( \"d_term\" );\n" +
                "\t\t\thideDIV( \"d_course\" );\n" +
                "\t\t\thideDIV( \"d_section\" );\n" +
                "\t\t\thideDIV( \"d_admin\" );\n" +
                "\t\t\thideDIV( \"d_dept\" );\n" +
                "\t\t\thideDIV( \"d_faculty\" );\n" +
                "\t\t\t\n" +
                "\t\t\tgetGradesYears();\n" +
                "\t\t}\t\n" +
                "\t\t\n" +
                "\t\tif ( reporttype == 'ASTUDENT' )\n" +
                "\t\t{\n" +
                "\t\t\thideDIV( \"d_campus\" );\n" +
                "\t\t\texpandDIV( \"d_email\" );\n" +
                "\t\t\thideDIV( \"d_subject\" );\n" +
                "\t\t\thideDIV( \"d_term\" );\n" +
                "\t\t\thideDIV( \"d_course\" );\n" +
                "\t\t\thideDIV( \"d_section\" );\n" +
                "\t\t\texpandDIV( \"d_admin\" );\n" +
                "\t\t\thideDIV( \"d_dept\" );\n" +
                "\t\t\thideDIV( \"d_faculty\" );\n" +
                "\t\t\t\n" +
                "\t\t\tif ( document.reportform.stud_no.value != '' )\n" +
                "\t\t\t{\n" +
                "\t\t\t\tgetStudentGradesYears();\n" +
                "\t\t\t}\n" +
                "\t\t\telse\n" +
                "\t\t\t\tclearGradesYears();\n" +
                "\t\t}\t\t\n" +
                "\t\t\n" +
                "\t\tif ( reporttype == 'DEPT' )\n" +
                "\t\t{\n" +
                "\t\t\texpandDIV( \"d_campus\" );\n" +
                "\t\t\texpandDIV( \"d_email\" );\n" +
                "\t\t\thideDIV( \"d_subject\" );\n" +
                "\t\t\thideDIV( \"d_term\" );\n" +
                "\t\t\thideDIV( \"d_course\" );\n" +
                "\t\t\thideDIV( \"d_section\" );\n" +
                "\t\t\thideDIV( \"d_admin\" );\n" +
                "\t\t\texpandDIV( \"d_dept\" );\n" +
                "\t\t\texpandDIV( \"d_faculty\" );\n" +
                "\t\t\t\n" +
                "\t\t\tgetYears();\n" +
                "\t\t}\t\n" +
                "\t\t\n" +
                "\t\tif ( reporttype == 'FACULTY' )\n" +
                "\t\t{\n" +
                "\t\t\texpandDIV( \"d_campus\" );\n" +
                "\t\t\texpandDIV( \"d_email\" );\n" +
                "\t\t\thideDIV( \"d_subject\" );\n" +
                "\t\t\thideDIV( \"d_term\" );\n" +
                "\t\t\thideDIV( \"d_course\" );\n" +
                "\t\t\thideDIV( \"d_section\" );\n" +
                "\t\t\thideDIV( \"d_admin\" );\n" +
                "\t\t\thideDIV( \"d_dept\" );\n" +
                "\t\t\texpandDIV( \"d_faculty\" );\n" +
                "\n" +
                "\t\t\tgetYears();\n" +
                "\t\t}\t\t\n" +
                "\t\t\n" +
                "\t\tif ( reporttype == 'FACULTY' || reporttype == 'DEPT' )\n" +
                "\t\t{\n" +
                "\t\t\tgetFaculties();\n" +
                "\t\t}\n" +
                "\t}\n" +
                "\t\t\n" +
                "\tfunction getYears()\n" +
                "\t{\n" +
                "\t    sisservice.getYearsessions( document.reportform.campus.value, createYearList );\t    \n" +
                "\t}\n" +
                "\t\n" +
                "\tfunction getGradesYears()\n" +
                "\t{\n" +
                "\t\tsisservice.getGradesYearsessions( createYearList );\t   \n" +
                "\t}\n" +
                "\t\n" +
                "\tfunction clearStudent()\n" +
                "\t{\n" +
                "\t\tdocument.reportform.stud_no.value = '';\n" +
                "\t}\n" +
                "\t\n" +
                "\tfunction clearGradesYears()\n" +
                "\t{\n" +
                "\t\tDWRUtil.removeAllOptions( \"yearsessionlist\" );\n" +
                "\t}\n" +
                "\t\n" +
                "\tfunction getStudentGradesYears()\n" +
                "\t{\n" +
                "\t\tsisservice.getStudentGradesYearsessions( document.reportform.stud_no.value, createYearList );\t   \n" +
                "\t}\n" +
                "\t\n" +
                "\tfunction createYearList(data)\n" +
                "\t{\n" +
                "\t    DWRUtil.removeAllOptions( \"yearsessionlist\" );\n" +
                "\t    DWRUtil.addOptions( \"yearsessionlist\", data, \"value\", \"label\" );\n" +
                "\t\n" +
                "\t    // Get a reference to the dept drop-down\n" +
                "\t    var myDropdownList = document.reportform.yearsession;\n" +
                "\t\n" +
                "\t    itemToSelect = \"2014W\";\n" +
                "\t\n" +
                "\t    // Loop through all the items\n" +
                "\t    for (iLoop = 0; iLoop < myDropdownList.options.length; iLoop++)\n" +
                "\t    {\n" +
                "\t      if ( myDropdownList.options[iLoop].value == itemToSelect )\n" +
                "\t      {\n" +
                "\t        // Item is found. Set its selected property, and exit the loop\n" +
                "\t        myDropdownList.options[iLoop].selected = true;\n" +
                "\t        break;\n" +
                "\t      }\n" +
                "\t    }\n" +
                "\n" +
                "\t\treporttype = getCheckedValue( document.reportform.reporttype );\n" +
                "\t\tif ( reporttype == \"SECTION\" )\n" +
                "\t \t\tgetTerms();\n" +
                "\t \telse\n" +
                "\t \t\tgetSubjects();\n" +
                "\t}\n" +
                "\t\n" +
                "\tfunction getTerms()\n" +
                "\t{\n" +
                "\t\tys = document.reportform.yearsession.value; \n" +
                "\t\tif ( ys.length >= 5 )\n" +
                "\t\t{\n" +
                "\t\t\tyear = ys.substring( 0, 4 );\n" +
                "\t\t\tsession = ys.substring( 4 );\n" +
                "\n" +
                "\t\t\tsisservice.getTerms( document.reportform.campus.value, year, session, createTermList );\t \n" +
                "\t\t}\t\t    \n" +
                "\t}\n" +
                "\t\n" +
                "\tfunction createTermList(data)\n" +
                "\t{\n" +
                "\t    DWRUtil.removeAllOptions( \"termlist\" );\n" +
                "\t    DWRUtil.addOptions( \"termlist\", data, \"value\", \"label\" );\n" +
                "\t\n" +
                "\t    // Get a reference to the dept drop-down\n" +
                "\t    var myDropdownList = document.reportform.term;\n" +
                "\t\n" +
                "\t    itemToSelect = \" \";\n" +
                "\t\n" +
                "\t    // Loop through all the items\n" +
                "\t    for (iLoop = 0; iLoop < myDropdownList.options.length; iLoop++)\n" +
                "\t    {\n" +
                "\t      if ( myDropdownList.options[iLoop].value == itemToSelect )\n" +
                "\t      {\n" +
                "\t        // Item is found. Set its selected property, and exit the loop\n" +
                "\t        myDropdownList.options[iLoop].selected = true;\n" +
                "\t        break;\n" +
                "\t      }\n" +
                "\t    }\n" +
                "\n" +
                "\t \tgetSubjects();\n" +
                "\t}\t\n" +
                "\t\n" +
                "\tfunction getSubjects()\n" +
                "\t{\n" +
                "\t\tDWRUtil.removeAllOptions( \"subjectlist\" );\n" +
                "\t\t\n" +
                "\t\treporttype = getCheckedValue( document.reportform.reporttype );\n" +
                "\t\tif ( reporttype != \"SECTION\" )\n" +
                "\t\t\tterm = null;\n" +
                "\t\telse\n" +
                "\t\t\tterm = document.reportform.term.value;\n" +
                "\t\t\n" +
                "\t\tsisservice.getSubjects( document.reportform.campus.value, \n" +
                "\t\t\tdocument.reportform.yearsession.value, \n" +
                "\t\t\tterm, \n" +
                "\t\t\tnull, null, \n" +
                "\t\t\tcreateSubjectList );\t\t\t\n" +
                "\t}\t\n" +
                "\t\n" +
                "\tfunction createSubjectList( data )\n" +
                "\t{    \t\n" +
                "    \tDWRUtil.addOptions( \"subjectlist\", data, \"value\", \"label\" );\n" +
                "    \t\n" +
                "\t    // Get a reference to the faculty drop-down\n" +
                "\t    var myDropdownList = document.reportform.subject;\n" +
                "\t\n" +
                "\t    itemToSelect = \"CPSC\";\n" +
                "\t    \n" +
                "\t    // Loop through all the items\n" +
                "\t    for (iLoop = 0; iLoop< myDropdownList.options.length; iLoop++)\n" +
                "\t    {\n" +
                "\t      if ( myDropdownList.options[iLoop].value == itemToSelect )\n" +
                "\t      {\n" +
                "\t        // Item is found. Set its selected property, and exit the loop\n" +
                "\t        myDropdownList.options[iLoop].selected = true;\n" +
                "\t        break;\n" +
                "\t      }\n" +
                "\t    }   \n" +
                "\t    \n" +
                "\t    getCourses();\n" +
                "\t}\n" +
                "\t\n" +
                "\tfunction getCourses()\n" +
                "\t{\n" +
                "\t\tsisservice.getCourses( \n" +
                "\t\t\tdocument.reportform.campus.value, \n" +
                "\t\t\tdocument.reportform.yearsession.value,  \n" +
                "\t\t\tnull,\n" +
                "\t\t\tnull, \n" +
                "\t\t\tnull, \n" +
                "\t\t\tdocument.reportform.subject.value, \n" +
                "\t\t\tcreateCourseList );\n" +
                "\t}\n" +
                "\t\n" +
                "\tfunction createCourseList( data )\n" +
                "\t{\n" +
                "\t    DWRUtil.removeAllOptions( \"courselist\" );\n" +
                "\t    DWRUtil.addOptions( \"courselist\", data, \"value\", \"label\" );\n" +
                "\t\n" +
                "\t    // Get a reference to the dept drop-down\n" +
                "\t    var myDropdownList = document.reportform.course;\n" +
                "\t\n" +
                "\t    itemToSelect = \"210\";\n" +
                "\t\n" +
                "\t    // Loop through all the items\n" +
                "\t    for (iLoop = 0; iLoop < myDropdownList.options.length; iLoop++)\n" +
                "\t    {\n" +
                "\t      if ( myDropdownList.options[iLoop].value == itemToSelect )\n" +
                "\t      {\n" +
                "\t        // Item is found. Set its selected property, and exit the loop\n" +
                "\t        myDropdownList.options[iLoop].selected = true;\n" +
                "\t        break;\n" +
                "\t      }\n" +
                "\t    }\n" +
                "\t    \n" +
                "\t    document.reportform.course.value = document.reportform.courselist.value;\n" +
                "\t\n" +
                "\t \tgetDetails();\t\t\n" +
                "\t}\t\n" +
                "\t\n" +
                "\tfunction getDetails()\n" +
                "\t{\n" +
                "\t\tsisservice.getDetails( document.reportform.campus.value, document.reportform.yearsession.value, \n" +
                "\t\t\tdocument.reportform.subject.value, document.reportform.course.value, createDetailList );\n" +
                "\t}\n" +
                "\t\n" +
                "\tfunction createDetailList( data )\n" +
                "\t{\n" +
                "\t    DWRUtil.removeAllOptions( \"detaillist\" );\n" +
                "\t    DWRUtil.addOptions( \"detaillist\", data, \"value\", \"label\" );\n" +
                "\t\n" +
                "\t    // Get a reference to the dept drop-down\n" +
                "\t    var myDropdownList = document.reportform.detaillist;\n" +
                "\t\n" +
                "\t    itemToSelect = \" \";\n" +
                "\t\n" +
                "\t    // Loop through all the items\n" +
                "\t    for (iLoop = 0; iLoop < myDropdownList.options.length; iLoop++)\n" +
                "\t    {\n" +
                "\t      if ( myDropdownList.options[iLoop].value == itemToSelect )\n" +
                "\t      {\n" +
                "\t        // Item is found. Set its selected property, and exit the loop\n" +
                "\t        myDropdownList.options[iLoop].selected = true;\n" +
                "\t        break;\n" +
                "\t      }\n" +
                "\t    }\n" +
                "\t\n" +
                "\t \tgetSections();\t\t\n" +
                "\t}\t\n" +
                "\t\n" +
                "\tfunction getSections()\n" +
                "\t{\n" +
                "\t\tsisservice.getSections( document.reportform.campus.value, \n" +
                "\t\t\tdocument.reportform.yearsession.value, \n" +
                "\t\t\tdocument.reportform.subject.value, \n" +
                "\t\t\tdocument.reportform.course.value, \n" +
                "\t\t\tdocument.reportform.detail.value, \n" +
                "\t\t\tcreateSectionList );\n" +
                "\t}\n" +
                "\t\n" +
                "\tfunction createSectionList( data )\n" +
                "\t{\n" +
                "\t    DWRUtil.removeAllOptions(\"sectionlist\");\n" +
                "\t    DWRUtil.addOptions(\"sectionlist\", data, \"value\", \"label\" );\n" +
                "\t\n" +
                "\t    // Get a reference to the dept drop-down\n" +
                "\t    var myDropdownList = document.reportform.sectionlist;\n" +
                "\t\n" +
                "\t    itemToSelect = \"101\";\n" +
                "\t\n" +
                "\t    // Loop through all the items\n" +
                "\t    for (iLoop = 0; iLoop < myDropdownList.options.length; iLoop++)\n" +
                "\t    {\n" +
                "\t      if ( myDropdownList.options[iLoop].value == itemToSelect )\n" +
                "\t      {\n" +
                "\t        // Item is found. Set its selected property, and exit the loop\n" +
                "\t        myDropdownList.options[iLoop].selected = true;\n" +
                "\t        break;\n" +
                "\t      }\n" +
                "\t    }\n" +
                "\t}\t\n" +
                "\t\n" +
                "\tfunction getFaculties()\n" +
                "\t{\n" +
                "\t\tcampus = document.reportform.campus.value;\n" +
                "\t\t\n" +
                "\t\tsisservice.getFaculties( \n" +
                "\t\t\t\tcampus,\n" +
                "\t\t\t\tcreateFacultyList );\n" +
                "\t}\n" +
                "\t\n" +
                "\tfunction createFacultyList( data )\n" +
                "\t{\t\t    \n" +
                "\t    DWRUtil.removeAllOptions( \"facultylist\" ); \n" +
                "\t    DWRUtil.addOptions( \"facultylist\", data, \"value\", \"label\" );\n" +
                "\t\n" +
                "\t    // Get a reference to the drop-down\n" +
                "\t    var myDropdownList = document.reportform.facultylist;\n" +
                "\t\n" +
                "\t    itemToSelect = document.reportform.faculty.value;\n" +
                "\t    \n" +
                "\t    // Loop through all the items\n" +
                "\t    for (iLoop = 0; iLoop< myDropdownList.options.length; iLoop++)\n" +
                "\t    {\n" +
                "\t      if ( myDropdownList.options[iLoop].value == itemToSelect )\n" +
                "\t      {\n" +
                "\t        // Item is found. Set its selected property, and exit the loop\n" +
                "\t        myDropdownList.options[iLoop].selected = true;\n" +
                "\t        break;\n" +
                "\t      }\n" +
                "\t    }\t   \n" +
                "\t    \n" +
                "\t    if ( document.reportform.faculty.value == '' )\n" +
                "\t    \t document.reportform.faculty.value = document.reportform.facultylist.value;\t\t\n" +
                "\n" +
                "\t\tgetDepts();\n" +
                "\t}\n" +
                "\t\n" +
                "\tfunction getDepts()\n" +
                "\t{\n" +
                "\t\tcampus = document.reportform.campus.value;\n" +
                "\t\tfaculty = document.reportform.faculty.value;\n" +
                "\t\tsisservice.getDepts( \n" +
                "\t\t\t\tcampus,\n" +
                "\t\t\t\tfaculty,\n" +
                "\t\t\t\tcreateDeptList );\n" +
                "\t}\n" +
                "\t\n" +
                "\tfunction createDeptList( data )\n" +
                "\t{\t\t    \n" +
                "\t    DWRUtil.removeAllOptions( \"deptlist\" ); \n" +
                "\t    DWRUtil.addOptions( \"deptlist\", data, \"value\", \"label\" );\n" +
                "\t\n" +
                "\t    // Get a reference to the drop-down\n" +
                "\t    var myDropdownList = document.reportform.deptlist;\n" +
                "\t\n" +
                "\t    itemToSelect = document.reportform.dept.value;\n" +
                "\t    \n" +
                "\t    // Loop through all the items\n" +
                "\t    for (iLoop = 0; iLoop< myDropdownList.options.length; iLoop++)\n" +
                "\t    {\n" +
                "\t      if ( myDropdownList.options[iLoop].value == itemToSelect )\n" +
                "\t      {\n" +
                "\t        // Item is found. Set its selected property, and exit the loop\n" +
                "\t        myDropdownList.options[iLoop].selected = true;\n" +
                "\t        break;\n" +
                "\t      }\n" +
                "\t    }\t   \n" +
                "\t    \n" +
                "\t    if ( document.reportform.dept.value == '' )\n" +
                "\t    \t document.reportform.dept.value = document.reportform.deptlist.value;\t\t\n" +
                "\n" +
                "\t}\n" +
                "\n" +
                "</script>\n" +
                "\n" +
                "\n" +
                "\t\n" +
                "\t<p>\n" +
                "<strong>Note</strong>:  UBC's grading policy requires that all partial grades be submitted \n" +
                "regardless of whether students complete the course.  Therefore, grades less \n" +
                "than 40% may be due to students who did not write the final exam and who did \n" +
                "not withdraw from the course.\t\n" +
                "\t</p><br/><br/>\n" +
                "\t<table border=\"0\" cellpadding=\"3\" cellspacing=\"3\">\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td>Instructor</td>\n" +
                "\t\t\t<td colspan=\"6\">Baniassad, Elisa</td>\n" +
                "\t\t</tr>\n" +
                "\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td>Year/session</td>\n" +
                "\t\t\t<td colspan=\"6\">2014</td>\n" +
                "\t\t</tr>\n" +
                "\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td>Course Subject</td>\n" +
                "\t\t\t<td colspan=\"6\">CPSC</td>\n" +
                "\t\t</tr>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td>Course #</td>\n" +
                "\t\t\t<td colspan=\"6\">210</td>\n" +
                "\t\t</tr>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td>Detail</td>\n" +
                "\t\t\t<td colspan=\"6\"> </td>\n" +
                "\t\t</tr>\t\t\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td>Section #</td>\n" +
                "\t\t\t<td colspan=\"6\">101</td>\n" +
                "\t\t</tr>\n" +
                "\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td>Title</td>\n" +
                "\t\t\t<td colspan=\"6\">SFTWR CONSTRUCTN</td>\n" +
                "\t\t</tr>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td>Enrolled</td>\n" +
                "\t\t\t<td colspan=\"6\">153</td>\n" +
                "\t\t</tr>\n" +
                "\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td colspan=\"7\">&nbsp;</td>\n" +
                "\t\t</tr>\n" +
                "\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td>Average</td>\n" +
                "\t\t\t<td>Standard deviation</td>\n" +
                "\t\t\t<td>High</td>\n" +
                "\t\t\t<td>Low</td>\n" +
                "\t\t\t<td>Pass</td>\n" +
                "\t\t\t<td>Fail</td>\n" +
                "\t\t\t<td>Withdrew</td>\n" +
                "\t\t\t<td>Other</td>\n" +
                "\t\t</tr>\n" +
                "\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td colspan=\"7\">&nbsp;</td>\n" +
                "\t\t</tr>\n" +
                "\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td>74.31</td>\n" +
                "\t\t\t<td>15.72</td>\n" +
                "\t\t\t<td>98</td>\n" +
                "\t\t\t<td>22</td>\n" +
                "\t\t\t<td>128</td>\n" +
                "\t\t\t<td>14</td>\n" +
                "\t\t\t<td>9</td>\n" +
                "\t\t\t<td>2</td>\n" +
                "\t\t</tr>\n" +
                "\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td colspan=\"7\">&nbsp;</td>\n" +
                "\t\t</tr>\n" +
                "\t\t\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td>0-9%</td>\n" +
                "\t\t\t<td colspan=\"6\">0</td>\n" +
                "\t\t</tr>\n" +
                "\t\t\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td>10-19%</td>\n" +
                "\t\t\t<td colspan=\"6\">0</td>\n" +
                "\t\t</tr>\n" +
                "\t\t\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td>20-29%</td>\n" +
                "\t\t\t<td colspan=\"6\">1</td>\n" +
                "\t\t</tr>\n" +
                "\t\t\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td>30-39%</td>\n" +
                "\t\t\t<td colspan=\"6\">4</td>\n" +
                "\t\t</tr>\n" +
                "\t\t\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td>40-49%</td>\n" +
                "\t\t\t<td colspan=\"6\">9</td>\n" +
                "\t\t</tr>\n" +
                "\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td>&lt;50%</td>\n" +
                "\t\t\t<td colspan=\"6\">14</td>\n" +
                "\t\t</tr>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td>50-54%</td>\n" +
                "\t\t\t<td colspan=\"6\">1</td>\n" +
                "\t\t</tr>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td>55-59%</td>\n" +
                "\t\t\t<td colspan=\"6\">3</td>\n" +
                "\t\t</tr>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td>60-63%</td>\n" +
                "\t\t\t<td colspan=\"6\">9</td>\n" +
                "\t\t</tr>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td>64-67%</td>\n" +
                "\t\t\t<td colspan=\"6\">14</td>\n" +
                "\t\t</tr>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td>68-71%</td>\n" +
                "\t\t\t<td colspan=\"6\">9</td>\n" +
                "\t\t</tr>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td>72-75%</td>\n" +
                "\t\t\t<td colspan=\"6\">14</td>\n" +
                "\t\t</tr>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td>76-79%</td>\n" +
                "\t\t\t<td colspan=\"6\">16</td>\n" +
                "\t\t</tr>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td>80-84%</td>\n" +
                "\t\t\t<td colspan=\"6\">13</td>\n" +
                "\t\t</tr>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td>85-89%</td>\n" +
                "\t\t\t<td colspan=\"6\">22</td>\n" +
                "\t\t</tr>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td>90-100%</td>\n" +
                "\t\t\t<td colspan=\"6\">27</td>\n" +
                "\t\t</tr>\n" +
                "\t</table>\t\n" +
                "\t\n" +
                "\n" +
                "\n" +
                "</div>\n" +
                "\n" +
                "<div class=\"panel\">\n" +
                "\n" +
                "<div id=\"primary\" class=\"aside\">\n" +
                "\n" +
                "<div id=\"olt-subpages-navigation-widget-3\"\n" +
                "\tclass=\"widget widget_subpages_navigation widget-widget_subpages_navigation\">\n" +
                "\t\n" +
                "<div class=\"widget-inside\">\n" +
                "<h3 class=\"widget-title\">Navigation</h3>\n" +
                "<ul\n" +
                "\tclass=\"subpages-navi subpages-navi-widget subpages-navi-exclusive subpages-navi-collapsible subpages-navi-auto-expand\">\n" +
                "\n" +
                "\t\n" +
                "\t<li class=\"subpages-navi-node subpages-navi-level-0\"><a\thref=\"/reports/logout.action\">Logout</a></li>\n" +
                "\t\n" +
                "\t\n" +
                "\t<li class=\"subpages-navi-node subpages-navi-level-0 subpages-navi-current-level\">\n" +
                "\t<a href=\"/reports/\">Home</a>\n" +
                "\t</li>\n" +
                "\t\n" +
                "\t\n" +
                "<!-- \n" +
                "\n" +
                "-->\n" +
                "\n" +
                "\n" +
                "\n" +
                "\t\n" +
                "\t\n" +
                "\n" +
                "<!-- \t\n" +
                "\t\n" +
                "\t<li class=\"subpages-navi-node subpages-navi-level-0\"><a\thref=\"http://www.ombudsoffice.ubc.ca/\">Office of the Ombudsperson for Students</a>\n" +
                "\t<ul class='children'>\n" +
                "\t\t\n" +
                "\t\t<li class=\"subpages-navi-node subpages-navi-level-1\">\n" +
                "\t\t\t<a href=\"/reports/forms_request.action?formname=ombudstudent20090727\">Student Online Request for Assistance</a>\n" +
                "\t\t</li>\n" +
                "\t\t\n" +
                "\t\t\n" +
                "\t\t\n" +
                "\t</ul>\t\t\n" +
                "\t</li>\n" +
                "\t\n" +
                "-->\t\t\n" +
                "\t\n" +
                "\t\t\t\n" +
                "\t<li class=\"subpages-navi-node subpages-navi-level-0\"><a\thref=\"http://www.students.ubc.ca/\">SIS Reports</a>\n" +
                "\t<ul class='children'>\n" +
                "\t\t<li class=\"subpages-navi-node subpages-navi-level-1\"><a\thref=\"/reports/autoreport_request.action?reportname=cs\" title=\"Classrooms and Space\">Classrooms and Space</a>\n" +
                "\t\t</li>\n" +
                "\n" +
                "\t\t<li class=\"subpages-navi-node subpages-navi-level-1\"><a href=\"/reports/crsdist_request.action\">Course Distribution Report</a></li>\n" +
                "\t\t<li class=\"subpages-navi-node subpages-navi-level-1\"><a href=\"/reports/enrl_request.action\">Course Enrollment Report</a></li>\n" +
                "\t\t<li class=\"subpages-navi-node subpages-navi-level-1\"><a href=\"/reports/degreeprofile_request.action\">Degree Profile Report</a></li>\n" +
                "\t\t\n" +
                "\t\t<li class=\"subpages-navi-node subpages-navi-level-1\"><a href=\"/reports/gradesdist_request.action\">Grades Distribution Report</a></li>\n" +
                "\t\t\t\n" +
                "\t\t\n" +
                "\t</ul>\n" +
                "\t</li>\t\n" +
                "\t\n" +
                "\t\n" +
                "</ul>\n" +
                "\n" +
                "</div>\n" +
                "</div>\n" +
                "\n" +
                "\n" +
                "<div id=\"linkcat-711\" class=\"widget bookmarks widget-bookmarks\">\n" +
                "<div class=\"widget-inside\">\n" +
                "<h3 class=\"widget-title\">Related Links</h3>\n" +
                "<ul class='xoxo blogroll'>\n" +
                "\t<li><a href=\"http://www.pair.ubc.ca\" onclick=\"window.open(this.href); return false;\" onkeypress=\"window.open(this.href); return false;\"><span>Planning &amp; Institutional Research web site</span></a></li>\n" +
                "</ul>\n" +
                "</div>\n" +
                "</div>\n" +
                "</div>\n" +
                "\n" +
                "</div><!-- panel --> \n" +
                "\n" +
                "</div><!-- #container -->\n" +
                "\n" +
                "<div id=\"footer-container\">\n" +
                "\n" +
                "\n" +
                "<div id=\"footer\" style=\"padding-left: 0px;\"><p style=\"font-size:80%;\">Best viewed with Mozilla Firefox or Internet Explorer 8.\n" +
                "In Internet Explorer, please turn off Compatibility View.</p></div>\n" +
                "<!-- #footer --></div>\n" +
                "<!-- #footer-container --></div>\n" +
                "<!-- #body-container -->\n" +
                "\n" +
                "<!-- END: UBC CLF CONTENT SPACE -->\n" +
                "<!-- BEGIN: UBC CLF FOOTER -->\n" +
                "<!-- BEGIN: UBC CLF VISUAL IDENTITY FOOTER -->\n" +
                "<div id=\"UbcBottomInfoWrapper\">\n" +
                "<div id=\"UbcBottomInfo\" class=\"UbcContainer\">\n" +
                "\n" +
                "<div id=\"UbcBottomLeft\">\n" +
                "<p><a href=\"http://www.ubc.ca\"><img src=\"/reports/_ubc_clf/img/footer/logo.gif\" alt=\"a place of mind, The University of British Columbia\" /></a></p>\n" +
                "</div>\n" +
                "<!-- End UbcBottomLeft -->\n" +
                "<div id=\"UbcBottomCenter\">\n" +
                "</div>\n" +
                "<!-- End UbcBottomCenter -->\n" +
                "<div id=\"UbcBottomRight\">\n" +
                "<p>UBC Planning &amp; Institutional Research<br/>\n" +
                "6328 Memorial Road<br/>\n" +
                "Vancouver, BC Canada V6T 1Z2\n" +
                "</p>\n" +
                "\n" +
                "<br />\n" +
                "</div>\n" +
                "<!-- End UbcBottomRight --></div>\n" +
                "<!-- End UbcBottomInfo UbcContainer --></div>\n" +
                "<!-- End UbcBottomInfoWrapper -->\n" +
                "<!-- END: UBC CLF VISUAL IDENTITY FOOTER -->\n" +
                "<!-- BEGIN: UBC CLF GLOBAL UTILITY FOOTER -->\n" +
                "<div id=\"UbcUtilNavWrapper\">\n" +
                "<div id=\"UbcUtilNav\" class=\"UbcContainer\">\n" +
                "<p><a href=\"http://www.emergency.ubc.ca/\">Emergency Procedures</a>&nbsp;|&nbsp;<a\n" +
                "\thref=\"http://www.ubc.ca/accessibility/\">Accessibility</a>&nbsp;|&nbsp;<a\n" +
                "\thref=\"http://www.ubc.ca/about/contact/\">Contact UBC</a>&nbsp;|&nbsp;<a\n" +
                "\thref=\"http://www.ubc.ca/copyright/\">&copy; Copyright The University\n" +
                "of British Columbia</a></p>\n" +
                "\n" +
                "</div>\n" +
                "<!-- End UbcUtilNav UbcContainer --></div>\n" +
                "<!-- End UbcUtilNavWrapper -->\n" +
                "<!-- END: UBC CLF GLOBAL UTILITY FOOTER -->\n" +
                "<!-- END: UBC CLF FOOTER -->\n" +
                "\n" +
                "</body>\n" +
                "</html>";
        grdResponse2 = " \n" +
                "\n" +
                "\n" +
                " \n" +
                "\n" +
                "\n" +
                "\n" +
                "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">\n" +
                "<html xmlns=\"http://www.w3.org/1999/xhtml\">\n" +
                "\n" +
                "<head>\n" +
                "\n" +
                "<title>Grades Distribution</title>\n" +
                "\n" +
                "<script type=\"text/javascript\">\n" +
                "// Turns MegaMenu on or off - See $(document).ready() in main.js\n" +
                "var UbcMegaMenu = true;\n" +
                "\n" +
                "// Turns Place of Mind Effect on or off - See $(document).ready() & Ubc.megaMenu.init() in main.js\n" +
                "var UbcPlaceOfMind = false;\n" +
                "\n" +
                "// Turns MainMenu drop-downs on or off - See $(document).ready() & Ubc.megaMenu.init() in main.js\n" +
                "var UbcMainMenuDropDown = false;\n" +
                "\n" +
                "// Appends URL string after http://www.aplaceofmind.ubc.ca/ in the Learn More button in the Place of Mind MegaMenu. \n" +
                "// Use an emptry string - i.e. \"\" - for the link to go directly to http://www.aplaceofmind.ubc.ca/\n" +
                "var UbcPlaceOfMindLink = \"\";\n" +
                "\n" +
                "// Sets the RSS feed address for the A Place of Mind effect -  See method Ubc.placeOfMind.loadRss() in main.js\n" +
                "var UbcPlaceOfMindRSS = \"\";\n" +
                "\n" +
                "// Set Search Label - If in doubt, use your unit's name.  i.e. Human Resources, Arts, President's Office, etc.\n" +
                "// See Ubc.search.init() in main.js\n" +
                "var SubUnitLabel = \"Planning and Institutional Research\";\n" +
                "\n" +
                "// Set Search Domain - Specify the domain for search results.  If in doubt, use *.yourdomain.ubc.ca - i.e. *.hr.ubc.ca, *.arts.ubc.ca, *.president.ubc.ca\n" +
                "// See Ubc.search.init() in main.js\n" +
                "var SearchSite = \"http://www.pair.ubc.ca\";\n" +
                "</script>\n" +
                "\n" +
                "<link rel=\"icon\"\n" +
                "\thref=\"/reports/images/favicon.ico\"\n" +
                "\ttype=\"image/x-icon\" />\n" +
                "\t\n" +
                "<link rel=\"shortcut icon\"\n" +
                "\thref=\"/reports/images/favicon.ico\"\n" +
                "\ttype=\"image/x-icon\" />\n" +
                "\n" +
                "<style type=\"text/css\">\n" +
                "body.textoption.option5 #UbcHeader a#UbcMindLink,body.textoption.option6 #UbcHeader a#UbcMindLink\n" +
                "{\n" +
                "\tbackground-color: #002859;\n" +
                "}\n" +
                "</style>\n" +
                "\n" +
                "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=iso-8859-1\" />\n" +
                "<meta http-equiv=\"Cache-Control\" content=\"no-store\"/>\n" +
                "<meta http-equiv=\"Expires\" content=\"-1\"/>\n" +
                "<meta http-equiv=\"Pragma\" content=\"no-cache\"/>\n" +
                "\n" +
                "<!-- Mimic Internet Explorer -->\n" +
                "<meta http-equiv=\"X-UA-Compatible\" content=\"IE=8\"/>\n" +
                "\n" +
                "<script type=\"text/javascript\" src=\"/reports/dwr/interface/sisservice.js\"></script>\n" +
                "<script type=\"text/javascript\" src=\"/reports/dwr/engine.js\"></script>\n" +
                "<script type=\"text/javascript\" src=\"/reports/dwr/util.js\"></script>\n" +
                "\t\n" +
                "<link rel='stylesheet' id='ubc_clf_clf-required-fixedwidth-css'\n" +
                "\thref='/reports/_ubc_clf/css/clf-required-fixedwidth.css'\n" +
                "\ttype='text/css' media='screen' />\n" +
                "\t\n" +
                "<link rel=\"stylesheet\"\n" +
                "\thref=\"/reports/css/style.css\" type=\"text/css\"\n" +
                "\tmedia=\"screen\" />\n" +
                "\t\n" +
                "<!--[if lte IE 7]>\n" +
                "<link href=\"/reports/_ubc_clf/css/ie.css\" type=\"text/css\" media=\"screen\" rel=\"Stylesheet\" />\n" +
                "<![endif]-->\n" +
                "\t\n" +
                "<script type=\"text/javascript\" src=\"https://www.google.com/jsapi\"></script>\n" +
                "\t\n" +
                "<script type='text/javascript'\n" +
                "\tsrc='/reports/scripts/jquery-1.4.2.min.js'></script>\n" +
                "\t\n" +
                "<script type='text/javascript'\n" +
                "\tsrc='/reports/scripts/subpages-navigation.js'></script>\n" +
                "\t\n" +
                "<script type='text/javascript'\n" +
                "\tsrc='/reports/_ubc_clf/js/main.js'></script>\n" +
                "\n" +
                "<script type=\"text/javascript\" src=\"/reports/yuibuild2.3.1/yahoo/yahoo.js\"></script>\n" +
                "<script type=\"text/javascript\" src=\"/reports/yuibuild2.3.1/event/event.js\" ></script>\n" +
                "<script type=\"text/javascript\" src=\"/reports/yuibuild2.3.1/dom/dom.js\" ></script>\n" +
                "<script type=\"text/javascript\" src=\"/reports/yuibuild2.3.1/calendar/calendar.js\"></script>\n" +
                "\n" +
                "<script type=\"text/javascript\" src=\"/reports/empty.txt\"></script>\n" +
                "<script type=\"text/javascript\" src=\"/reports/empty.txt\"></script>\n" +
                "<script type=\"text/javascript\" src=\"/reports/empty.txt\"></script>\n" +
                "<script type=\"text/javascript\" src=\"/reports/empty.txt\"></script>\n" +
                "<script type=\"text/javascript\" src=\"/reports/empty.txt\"></script>\n" +
                "\n" +
                "<script type=\"text/javascript\">\n" +
                "\tfunction cursor_wait() \n" +
                "\t{\n" +
                "\t\tdocument.body.style.cursor = 'wait';\n" +
                "\t}\n" +
                "\t\n" +
                "\tfunction cursor_clear() \n" +
                "\t{\n" +
                "\t\tdocument.body.style.cursor = 'default';\n" +
                "\t}\n" +
                "\n" +
                "\tString.prototype.trim = function() \n" +
                "\t{\n" +
                "\t\treturn this.replace(/^\\s+|\\s+$/g,\"\");\n" +
                "\t}\n" +
                "\tString.prototype.ltrim = function() \n" +
                "\t{\n" +
                "\t\treturn this.replace(/^\\s+/,\"\");\n" +
                "\t}\n" +
                "\tString.prototype.rtrim = function() \n" +
                "\t{\n" +
                "\t\treturn this.replace(/\\s+$/,\"\");\n" +
                "\t}\t\n" +
                "\t\n" +
                "\tvar visible, hidden;\n" +
                "\n" +
                "\tif ( document.layers )\n" +
                "\t{\n" +
                "\t  visible = 'show';\n" +
                "\t  hidden = 'hide';\n" +
                "\t}\n" +
                "\telse if ( document.all )\n" +
                "\t{\n" +
                "\t  visible = 'visible';\n" +
                "\t  hidden = 'hidden';\n" +
                "\t}\n" +
                "\telse if ( document.getElementById )\n" +
                "\t{\n" +
                "\t  visible = 'visible';\n" +
                "\t  hidden = 'hidden';\n" +
                "\t}\n" +
                "\n" +
                "\tfunction showmenu( elmnt, cell )\n" +
                "\t{\n" +
                "\n" +
                "\t  if ( document.layers )\n" +
                "\t  {\n" +
                "\t\tdaElmnt = document.layers[elmnt];\n" +
                "\t\tdaCell = document.layers[ cell ];\n" +
                "\t  }\n" +
                "\t  else if ( document.all )\n" +
                "\t  {\n" +
                "\t\tdaElmnt = document.all( elmnt );\n" +
                "\t\tdaCell = document.all( cell );\n" +
                "\t  }\n" +
                "\t  else if ( document.getElementById )\n" +
                "\t  {\n" +
                "\t\tdaElmnt = document.getElementById( elmnt );\n" +
                "\t\tdaCell = document.getElementById( cell );\n" +
                "\t\tp = daCell;\n" +
                "\t\toffsetleft = 0;\n" +
                "\t\toffsettop = 0;\n" +
                "\t\twhile ( p != null )\n" +
                "\t\t{\n" +
                "\t\t\toffsetleft += p.offsetLeft;\n" +
                "\t\t\toffsettop += p.offsetTop;\n" +
                "\n" +
                "\t\t\tp = p.offsetParent;\n" +
                "\t\t}\n" +
                "\n" +
                "\t\tdaElmnt.style.left = offsetleft;\n" +
                "\n" +
                "\t\tdaElmnt.style.top = offsettop + 18;\n" +
                "\n" +
                "\t  }\n" +
                "\n" +
                "\t  daElmnt.style.visibility = visible;\n" +
                "\t}\n" +
                "\n" +
                "\tfunction hidemenu( elmnt )\n" +
                "\t{\n" +
                "\t  if (document.layers)\n" +
                "\t  {\n" +
                "\t\tdaElmnt = document.layers[elmnt];\n" +
                "\t  } \n" +
                "\t  else if ( document.all )\n" +
                "\t  {\n" +
                "\t\tdaElmnt = document.all( elmnt );\n" +
                "\t  }\n" +
                "\t  else if ( !document.layers && !document.all && document.getElementById )\n" +
                "\t  {\n" +
                "\t\tdaElmnt = document.getElementById( elmnt );\n" +
                "\t  }\n" +
                "\n" +
                "\t  daElmnt.style.visibility = 'hidden';\n" +
                "\n" +
                "\t}\n" +
                "\t\n" +
                "\tfunction expandDIV( whichElement )\n" +
                "\t{\t\t\n" +
                "\t\tvar elem, vis;\n" +
                "\t\tif( document.getElementById ) // this is the way the standards work\n" +
                "\t\t{\n" +
                "\t\t\telem = document.getElementById( whichElement );\n" +
                "\t\t}\n" +
                "\t\telse if( document.all ) // this is the way old msie versions work\n" +
                "\t\t{\n" +
                "\t\t    elem = document.all[whichElement];\n" +
                "\t\t}\n" +
                "\t\telse if( document.layers ) // this is the way nn4 works\n" +
                "\t\t{\n" +
                "\t\t  \telem = document.layers[whichElement];\n" +
                "\t\t}\n" +
                "\t\t\n" +
                "\t\tvis = elem.style;\n" +
                "\t\t\n" +
                "\t\tvis.display = 'block';\n" +
                "\t}\n" +
                "\n" +
                "\tfunction hideDIV( whichElement )\n" +
                "\t{\n" +
                "\t\tvar elem, vis;\n" +
                "\t\tif( document.getElementById ) // this is the way the standards work\n" +
                "\t\t{\n" +
                "\t\t\telem = document.getElementById( whichElement );\n" +
                "\t\t}\n" +
                "\t\telse if( document.all ) // this is the way old msie versions work\n" +
                "\t\t{\n" +
                "\t\t    elem = document.all[whichElement];\n" +
                "\t\t}\n" +
                "\t\telse if( document.layers ) // this is the way nn4 works\n" +
                "\t\t{\n" +
                "\t\t  \telem = document.layers[whichElement];\n" +
                "\t\t}\n" +
                "\t\t\n" +
                "\t\tvis = elem.style;\n" +
                "\t\t\n" +
                "\t\tvis.display = 'none';\n" +
                "\t}\t\n" +
                "\t\n" +
                "\tfunction checkAll( radioObj ) \n" +
                "\t{\n" +
                "\t\tif ( !radioObj )\n" +
                "\t\t\treturn;\n" +
                "\t\t\n" +
                "\t\tvar radioLength = radioObj.length;\n" +
                "\t\tif ( radioLength == undefined ) \n" +
                "\t\t{\n" +
                "\t\t\treturn;\n" +
                "\t\t}\n" +
                "\t\t\n" +
                "\t\tfor ( var i = 0; i < radioLength; i++ ) \n" +
                "\t\t{\n" +
                "\t\t\tradioObj[i].checked = true;\n" +
                "\t\t}\n" +
                "\t}\n" +
                "\t\n" +
                "\tfunction decheckAll( radioObj ) \n" +
                "\t{\n" +
                "\t\tif ( !radioObj )\n" +
                "\t\t\treturn;\n" +
                "\t\tvar radioLength = radioObj.length;\n" +
                "\t\tif ( radioLength == undefined ) \n" +
                "\t\t{\n" +
                "\t\t\treturn;\n" +
                "\t\t}\n" +
                "\t\t\n" +
                "\t\tfor ( var i = 0; i < radioLength; i++ ) \n" +
                "\t\t{\n" +
                "\t\t\tradioObj[i].checked = false;\n" +
                "\t\t}\n" +
                "\t}\t\n" +
                "\t\t\n" +
                "\tfunction getCheckedValue( radioObj ) \n" +
                "\t{\n" +
                "\t\tif( !radioObj )\n" +
                "\t\t\treturn \"\";\n" +
                "\t\tvar radioLength = radioObj.length;\n" +
                "\t\tif ( radioLength == undefined )\n" +
                "\t\t\tif( radioObj.checked )\n" +
                "\t\t\t\treturn radioObj.value;\n" +
                "\t\t\telse\n" +
                "\t\t\t\treturn \"\";\n" +
                "\t\tfor ( var i = 0; i < radioLength; i++ ) {\n" +
                "\t\t\tif ( radioObj[i].checked ) {\n" +
                "\t\t\t\treturn radioObj[i].value;\n" +
                "\t\t\t}\n" +
                "\t\t}\n" +
                "\t\treturn \"\";\n" +
                "\t}\n" +
                "\t\n" +
                "\tfunction setCheckedValue( radioObj, newValue ) \n" +
                "\t{\n" +
                "\t\tif( !radioObj )\n" +
                "\t\t\treturn;\n" +
                "\t\tvar radioLength = radioObj.length;\n" +
                "\t\tif( radioLength == undefined ) {\n" +
                "\t\t\tradioObj.checked = ( radioObj.value == newValue.toString() );\n" +
                "\t\t\treturn;\n" +
                "\t\t}\n" +
                "\t\tfor( var i = 0; i < radioLength; i++ ) {\n" +
                "\t\t\tradioObj[i].checked = false;\n" +
                "\t\t\tif(radioObj[i].value == newValue.toString()) {\n" +
                "\t\t\t\tradioObj[i].checked = true;\n" +
                "\t\t\t}\n" +
                "\t\t}\n" +
                "\t}\t\n" +
                "\n" +
                "\tfunction getSelectedValues( ob ) \n" +
                "\t{ \n" +
                "\t\tselected = new Array(); \n" +
                "\t\tfor ( i = 0; i < ob.options.length; i++ ) \n" +
                "\t\t\tif ( ob.options[ i ].selected ) \n" +
                "\t\t\t\tselected.push( ob.options[ i ].value );\n" +
                "\n" +
                "\t\treturn selected;\n" +
                "\t}\n" +
                "\n" +
                "\tfunction getSelectedValue( ob ) \n" +
                "\t{ \n" +
                "\t\treturn ob.value;\n" +
                "\t}\n" +
                "\n" +
                "\tfunction getSelectValues( ob )\n" +
                "\t{\n" +
                "\t\tselected = new Array(); \n" +
                "\t\tfor ( i = 0; i < ob.options.length; i++ ) \n" +
                "\t\t\tselected.push( ob.options[ i ].value );\n" +
                "\n" +
                "\t\treturn selected;\n" +
                "\t}\n" +
                "\t\n" +
                "\tfunction setSelectedValue(listObj, itemToSelect) \n" +
                "\t{\n" +
                "\t\tif ( !listObj )\n" +
                "\t\t\treturn false;;\n" +
                "\t\t\t\n" +
                "\t    // Loop through all the items\n" +
                "\t    for ( iLoop = 0; iLoop< listObj.options.length; iLoop++ )\n" +
                "\t    {\n" +
                "\t    \tif ( listObj.options[ iLoop ].value == itemToSelect )\n" +
                "\t      \t{\n" +
                "\t        \t// Item is found. Set its selected property, and exit the loop\n" +
                "\t        \tlistObj.options[ iLoop ].selected = true;\n" +
                "\t        \treturn true;;\n" +
                "\t      \t}\n" +
                "\t    }\n" +
                "\t    \n" +
                "\t    return false;\n" +
                "\t}\t\n" +
                "\n" +
                "\tfunction setSelectedValues( listObj, items )\n" +
                "\t{\n" +
                "\t\tif ( !listObj )\n" +
                "\t\t\treturn;\n" +
                "\t\t\t\n" +
                "\t    // Loop through all the items\n" +
                "\t    for ( i = 0; i < items.length; i++ )\n" +
                "\t    {\n" +
                "\t    \titemToSelect = items[ i ];\n" +
                "\t\t    for ( iLoop = 0; iLoop < listObj.options.length; iLoop++ )\n" +
                "\t\t    {\n" +
                "\t\t    \tif ( listObj.options[ iLoop ].value == itemToSelect )\n" +
                "\t\t      \t{\n" +
                "\t\t        \t// Item is found. Set its selected property, and exit the loop\n" +
                "\t\t        \tlistObj.options[ iLoop ].selected = true;\n" +
                "\t\t        \tbreak;\n" +
                "\t\t      \t}\n" +
                "\t\t    }\n" +
                "\t    }\n" +
                "\t}\n" +
                "\n" +
                "\tfunction unSelectAll(listObj) \n" +
                "\t{\n" +
                "\t\tif ( !listObj )\n" +
                "\t\t\treturn;\n" +
                "\t\t\t\n" +
                "\t    // Loop through all the items\n" +
                "\t    for ( iLoop = 0; iLoop< listObj.options.length; iLoop++ )\n" +
                "\t    {\n" +
                "\t        listObj.options[ iLoop ].selected = false;\n" +
                "\t    }\n" +
                "\t}\t\n" +
                "\n" +
                "\tfunction clearlist( listobj )\n" +
                "\t{\n" +
                "\t\tunSelectAll( listobj );\n" +
                "\t}\n" +
                "\t\n" +
                "\tfunction formatyui231( args ) \n" +
                "\t{\n" +
                "\t\tdates = args[0];\n" +
                "\t\tdate = dates[0];\n" +
                "\t\tyear = date[0], month = date[1], day = date[2];\n" +
                "\t\n" +
                "\t\tif ( month < 10 )\n" +
                "\t\t\tmonth = \"0\" + month;\n" +
                "\t\tif ( day < 10 )\n" +
                "\t\t\tday = \"0\" + day;\n" +
                "\t\t\t\n" +
                "\t\treturn year + \"-\" + month + \"-\" + day;\n" +
                "\t}     \t\t\n" +
                "</script>\n" +
                "\n" +
                "<link href=\"/reports/empty.css\" rel=\"stylesheet\" type=\"text/css\"/>\n" +
                "<link href=\"/reports/empty.css\" rel=\"stylesheet\" type=\"text/css\"/>\n" +
                "\n" +
                "<style type=\"text/css\" media=\"screen\">\n" +
                "<!--\n" +
                "@import\n" +
                "\turl(\"/reports/css/displaytag/displaytag.css\")\n" +
                "\t;\n" +
                "\n" +
                "@import\n" +
                "\turl(\"/reports/css/displaytag/alternative.css\")\n" +
                "\t;\n" +
                "\n" +
                "@import\n" +
                "\turl(\"/reports/struts/assets/calendar.css\");\n" +
                "\n" +
                "-->\n" +
                "\n" +
                "#body-container {\n" +
                "\toverflow: visible;\n" +
                "}\n" +
                "\n" +
                "#webappcontent {\n" +
                "\t/*text-align:justify;*/\n" +
                "\tmin-height: 400px;\n" +
                "\tborder:0 none;\n" +
                "\t\n" +
                "\t\n" +
                "\tdisplay:inline;\n" +
                "\tfloat:left;\n" +
                "\tmargin:0;\n" +
                "\tpadding: 5px;\n" +
                "\t/*width:980px;*/\n" +
                "\t\n" +
                "\t/*outline: #0000FF dotted thin;*/\n" +
                "}\n" +
                "\n" +
                "#webappcontent html, body, div, span, applet, object, iframe, h1, h2, h3, h4, h5, h6, p, blockquote, pre, a, abbr, acronym, address, big, cite, code, del, dfn, em, font, img, ins, kbd, q, s, samp, small, strike, sub, sup, tt, var, b, u, i, center, dl, dt, dd, ol, ul, li, fieldset, form, label, legend, table, caption, tbody, tfoot, thead, tr, th, td {\n" +
                "\tbackground:none repeat scroll 0 0 transparent;\n" +
                "\tvertical-align: top;\n" +
                "}\n" +
                "\n" +
                "#webappcontent li {\n" +
                "\tmargin-bottom:4px;\n" +
                "\tmargin-left: 4px;\n" +
                "}\n" +
                "\n" +
                ".panel {\n" +
                "\tposition: absolute;\n" +
                "\tright: 0;\n" +
                "\tdisplay: none;\n" +
                "\tbackground: #FFFFFF;\n" +
                "\t/*border:1px solid #111111;*/\n" +
                "\tborder: 0px;\n" +
                "\twidth: 250px;\n" +
                "\t/*height: auto;*/ /*padding: 30px 30px 30px 130px;*/\n" +
                "\tfilter: alpha(opacity = 85);\n" +
                "\topacity: .85;\n" +
                "\t/*height: 400px;*/\n" +
                "\toverflow: visible;\n" +
                "}\n" +
                "\n" +
                ".panel p {\n" +
                "\tmargin: 0 0 15px 0;\n" +
                "\tpadding: 0;\n" +
                "\tcolor: #cccccc;\n" +
                "}\n" +
                "\n" +
                "a.navtrigger { /*position: absolute;*/\n" +
                "\ttext-decoration: none;\n" +
                "\t/*top: 50px;*/\n" +
                "\tright: 0;\n" +
                "\t/*font-size: 16px;*/ /*letter-spacing:-1px;*/\n" +
                "\t/*font-family: verdana, helvetica, arial, sans-serif;*/ /*color:#fff;*/\n" +
                "\t/*padding: 20px 40px 20px 15px;*/ /*font-weight: 700;*/\n" +
                "\t/*background:#333333 url(/reports/images/plus.gif) 85% 55% no-repeat;*/\n" +
                "\tbackground: #FFFFFF url(/reports/images/plus.gif) no-repeat;\n" +
                "\tpadding: 0px 0px 0px 20px;\n" +
                "\t/*border:1px solid #444444;*/\n" +
                "\tdisplay: block;\n" +
                "}\n" +
                "\n" +
                "a.navtrigger:hover { /*position: absolute;*/\n" +
                "\ttext-decoration: none;\n" +
                "\t/*top: 50px;*/\n" +
                "\tright: 0;\n" +
                "\t/*font-size: 16px;*/ /*letter-spacing:-1px;*/\n" +
                "\t/*font-family: verdana, helvetica, arial, sans-serif;*/ /*color:#fff;*/\n" +
                "\t/*padding: 20px 40px 20px 15px;*/ /*font-weight: 700;*/\n" +
                "\t/*background:#222222 url(/reports/images/plus.gif) 85% 55% no-repeat;*/\n" +
                "\tbackground: #FFFFFF url(/reports/images/plus.gif) no-repeat;\n" +
                "\tpadding: 0px 0px 0px 20px;\n" +
                "\t/*border:1px solid #444444;*/\n" +
                "\tdisplay: block;\n" +
                "}\n" +
                "\n" +
                "a.active.navtrigger {\n" +
                "\t/*background:#222222 url(/reports/images/minus.gif) 85% 55% no-repeat;*/\n" +
                "\tbackground: #FFFFFF url(/reports/images/minus.gif) no-repeat;\n" +
                "\tpadding: 0px 0px 0px 20px;\n" +
                "}\n" +
                "</style>\n" +
                "\n" +
                "<!-- \n" +
                "<script type=\"text/javascript\" src=\"http://jqueryjs.googlecode.com/files/jquery-1.3.2.js\"></script>\n" +
                " -->\t\n" +
                "\t\n" +
                "<script type=\"text/javascript\">\n" +
                "$(document).ready(function(){\n" +
                "\t$(\".navtrigger\").click(function(){\n" +
                "\t\t$(\".panel\").toggle(\"fast\");\n" +
                "\t\t$(this).toggleClass(\"active\");\n" +
                "\t\treturn false;\n" +
                "\t});\n" +
                "});\n" +
                "</script>\n" +
                "\n" +
                "\n" +
                "</head>\n" +
                "\n" +
                "<body\n" +
                "\tclass=\"ltr y2010 m04 d15 h05 thursday not-logged-in home front-page singular page page-3 page-template page-template-default page-author-nrogic windows firefox firefox-3 primary-active secondary-inactive subsidiary-inactive option1 textoption\">\n" +
                "\n" +
                "<!-- BEGIN: UBC CLF HEADER -->\n" +
                "<div id=\"UbcHeaderWrapper\"><!-- BEGIN: UBC CLF GLOBAL UTILITY HEADER -->\n" +
                "<div id=\"UbcToolBarWrapper\">\n" +
                "<div id=\"UbcToolBar\" class=\"UbcContainer\">\n" +
                "<ul id=\"UbcToolNav\" style=\"list-style: none outside none;\">\n" +
                "\t<li><a id=\"UbcCampusLinks\" href=\"http://www.ubc.ca/campuses/\">Campuses</a></li>\n" +
                "\t<li><a id=\"UbcDirectLinks\" href=\"http://www.ubc.ca/directories/\">UBC\n" +
                "\tDirectories</a></li>\n" +
                "\t<li><a id=\"UbcQuickLinks\" href=\"http://www.ubc.ca/quicklinks/\">UBC\n" +
                "\tQuick Links</a></li>\n" +
                "\t<li class=\"UbcForm\">\n" +
                "\t<form id=\"UbcSearchForm\" action=\"http://www.ubc.ca/search/\"\n" +
                "\t\tmethod=\"get\">\n" +
                "\t<input type=\"text\" name=\"q\" value=\"\" class=\"UbcSearchField\" />\n" +
                "\t<input type=\"image\"\n" +
                "\t\tsrc=\"/reports/_ubc_clf/img/header/spacer.gif\"\n" +
                "\t\tclass=\"UbcSearchBtn\" value=\"Search\" alt=\"Search\" />\n" +
                "\t</form>\n" +
                "\t</li>\n" +
                "</ul>\n" +
                "\n" +
                "</div>\n" +
                "<!-- End UbcToolBar UbcContainer --></div>\n" +
                "<!-- End UbcToolBarWrapper -->\n" +
                "<div id=\"UbcMegaMenuesWrapper\" class=\"UbcContainer\">\n" +
                "<div id=\"UbcMegaMenues\" class=\"UbcContainer\"><a href=\"#\"\n" +
                "\tclass=\"UbcCloseBtn\">[X] close</a></div>\n" +
                "<!-- End UbcMegaMenues UbcContainer --></div>\n" +
                "<!-- End UbcMegaMenuesWrapper UbcContainer --> <!-- END: UBC CLF GLOBAL UTILITY HEADER -->\n" +
                "<!-- BEGIN: UBC CLF VISUAL IDENTITY HEADER -->\n" +
                "<ul id=\"UbcHeader\" class=\"UbcContainer\" style=\"list-style: none outside none;\">\n" +
                "\n" +
                "\t<li>\n" +
                "\t<h1 id=\"UbcLogo\"><a href=\"http://www.ubc.ca/\">The University\n" +
                "\tof British Columbia</a></h1>\n" +
                "\t</li>\n" +
                "\t<li class=\"UbcMindLink\"><a href=\"http://www.aplaceofmind.ubc.ca/\"\n" +
                "\t\tid=\"UbcMindLink\">a place of mind</a></li>\n" +
                "\t<li id=\"UbcHeaderLine\"><a href=\"http://www.ubc.ca\"\n" +
                "\t\tid=\"UbcHeaderLink\"><span>The University of British Columbia</span></a></li>\n" +
                "\t<li id=\"UbcSubUnitLine\"><a href=\"http://www.pair.ubc.ca\"\n" +
                "\t\tid=\"UbcSubUnitLink\"><span>Planning &amp; Institutional Research</span></a></li>\n" +
                "</ul>\n" +
                "\n" +
                "</div>\n" +
                "<!-- End UbcHeaderWrapper -->\n" +
                "\n" +
                "\n" +
                "<div id=\"body-container\">\n" +
                "\n" +
                "<div id=\"header-container\">\n" +
                "\n" +
                "<div id=\"header\"></div>\n" +
                "<!-- #header --></div>\n" +
                "<!-- #header-container -->\n" +
                "\n" +
                "<div id=\"main-nav\">\n" +
                "<ul class=\"main-menu\">\t\t\n" +
                "\t<li class=\"navtrigger page-list-1 page_item page-item-1\"><a\n" +
                "\t\thref=\"#\" \n" +
                "\t\ttitle=\"Navigation\">Side-bar<br/>navigation</a>\n" +
                "\t</li>\n" +
                "\t\n" +
                "\t<li class=\"page-list-1 page_item page-item-3 current_page_item\"><a\n" +
                "\t\thref=\"/reports\" title=\"Home\">Home</a>\n" +
                "\t</li>\n" +
                "\t\t\n" +
                "\t\n" +
                "\t<li class=\"page-list-1 page_item page-item-3 current_page_item\"><a\thref=\"/reports/logout.action\">Logout</a></li>\n" +
                "\t\t\n" +
                "\n" +
                "\t\n" +
                "<!-- \n" +
                "\t\n" +
                "-->\n" +
                "\n" +
                "\t\n" +
                "\t\n" +
                "\t\n" +
                "\t\n" +
                "\t<!-- \n" +
                "\t\n" +
                "\t<li class=\"page-list-1 page_item page-item-77\"><a\n" +
                "\t\thref=\"http://www.ombudsoffice.ubc.ca/\"\n" +
                "\t\ttitle=\"Office of Ombudsperson for Students\">Ombudsperson<br/>for Students</a>\n" +
                "\t<ul>\n" +
                "\t\t\n" +
                "\t\t<li class=\"page-list-1 page_item page-item-35\">\n" +
                "\t\t\t<a href=\"/reports/forms_request.action?formname=ombudstudent20090727\">Student Online Request for Assistance</a>\n" +
                "\t\t</li>\n" +
                "\t\t\n" +
                "\t\t\n" +
                "\t\t\n" +
                "\t</ul>\t\t\n" +
                "\t</li>\n" +
                "\t\n" +
                "\t-->\n" +
                "\t\n" +
                "\t\t\t\t\n" +
                "\t<li class=\"page-list-1 page_item page-item-61\"><a\n" +
                "\t\thref=\"http://www.students.ubc.ca/\" title=\"SIS Reports\">SIS Reports</a>\n" +
                "\t<ul>\n" +
                "\t\t\n" +
                "\n" +
                "\t\t<li class=\"page-list-1 page_item page-item-41\"><a href=\"/reports/autoreport_request.action?reportname=cs\" title=\"Classrooms and Space\">Classrooms and Space</a></li>\n" +
                "\t\t\n" +
                "\t\t<li class=\"page-list-1 page_item page-item-35\"><a href=\"/reports/crsdist_request.action\">Course Distribution Report</a></li>\n" +
                "\t\t<li class=\"page-list-1 page_item page-item-41\"><a href=\"/reports/enrl_request.action\">Course Enrollment Report</a></li>\n" +
                "\t\t<li class=\"page-list-1 page_item page-item-35\"><a href=\"/reports/degreeprofile_request.action\">Degree Profile Report</a></li>\n" +
                "\t\t\n" +
                "\t\t<li class=\"page-list-1 page_item page-item-41\"><a href=\"/reports/gradesdist_request.action\">Grades Distribution Report</a></li>\t\t\t\t\n" +
                "\t\t\n" +
                "\t\t\n" +
                "\t</ul>\n" +
                "\t</li>\t\n" +
                "\t\n" +
                "\t\t\n" +
                "</ul>\n" +
                "</div>\n" +
                "\n" +
                "<div id=\"container\">\n" +
                "\n" +
                "<div id=\"webappcontent\">\n" +
                " \n" +
                "\n" +
                "\n" +
                " \n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "<h2>Grades Distribution</h2>\n" +
                "\n" +
                "\n" +
                "\n" +
                "<form id=\"gradesdist_runreport\" name=\"reportform\" action=\"/reports/gradesdist_runreport.action\" method=\"post\">\n" +
                "\n" +
                "\t<input type=\"hidden\" name=\"struts.token.name\" value=\"token\" />\n" +
                "<input type=\"hidden\" name=\"token\" value=\"937OOI5P66LB5AS7VCC5AQIV6VNT5QNV\" />\n" +
                "\t\n" +
                "\t<input type=\"hidden\" name=\"faculty\" value=\"\" id=\"gradesdist_runreport_faculty\"/>\n" +
                "\t<input type=\"hidden\" name=\"dept\" value=\"\" id=\"gradesdist_runreport_dept\"/>\n" +
                "\t\n" +
                "\t\t\n" +
                "\t<div id=\"wwgrp_gradesdist_runreport_reporttype\" class=\"wwgrp\">\n" +
                "<span id=\"wwlbl_gradesdist_runreport_reporttype\" class=\"wwlbl\">\n" +
                "<label for=\"gradesdist_runreport_reporttype\" class=\"label\">        Report type:\n" +
                "</label></span> <span id=\"wwctrl_gradesdist_runreport_reporttype\" class=\"wwctrl\">\n" +
                "    \n" +
                "<input type=\"radio\" name=\"reporttype\" id=\"gradesdist_runreport_reporttypeSECTION\" checked=\"checked\" value=\"SECTION\" onchange=\"showform();\"/><label for=\"gradesdist_runreport_reporttypeSECTION\">Specific section<br/></label>\n" +
                "<input type=\"radio\" name=\"reporttype\" id=\"gradesdist_runreport_reporttypeCOURSE\" value=\"COURSE\" onchange=\"showform();\"/><label for=\"gradesdist_runreport_reporttypeCOURSE\">Specific course<br/></label>\n" +
                "<input type=\"radio\" name=\"reporttype\" id=\"gradesdist_runreport_reporttypeSUBJECT\" value=\"SUBJECT\" onchange=\"showform();\"/><label for=\"gradesdist_runreport_reporttypeSUBJECT\">Specific subject<br/></label>\n" +
                "</span> </div>\n" +
                "\t\n" +
                "\t\n" +
                "\t<br/><br/>\t\n" +
                "\t\n" +
                "\t<div id=\"d_admin\" class=\"hiddentext\">\n" +
                "\t<div id=\"wwgrp_stud_no\" class=\"wwgrp\">\n" +
                "<span id=\"wwlbl_stud_no\" class=\"wwlbl\">\n" +
                "<label for=\"stud_no\" class=\"label\">        Student #:\n" +
                "</label></span> <span id=\"wwctrl_stud_no\" class=\"wwctrl\">\n" +
                "    \n" +
                "<input type=\"text\" name=\"stud_no\" size=\"10\" maxlength=\"8\" value=\"\" id=\"stud_no\" onfocus=\"clearGradesYears()\"/></span> </div>\t\n" +
                "\t\t\n" +
                "\t<br/>\n" +
                "\t<input type=\"button\" value=\"Refresh Year/Sessions\" onclick=\"getStudentGradesYears();\"/>\t\t\n" +
                "\t<br/><br/>\n" +
                "\t</div>\n" +
                "\t\n" +
                "\t<div id=\"d_campus\" class=\"hiddentext\">\n" +
                "\t\n" +
                "\t<div id=\"wwgrp_gradesdist_runreport_campus\" class=\"wwgrp\">\n" +
                "<span id=\"wwlbl_gradesdist_runreport_campus\" class=\"wwlbl\">\n" +
                "<label for=\"gradesdist_runreport_campus\" class=\"label\">        Campus:\n" +
                "</label></span> <span id=\"wwctrl_gradesdist_runreport_campus\" class=\"wwctrl\">\n" +
                "    \n" +
                "<select name=\"campus\" id=\"gradesdist_runreport_campus\" onchange=\"getYears();\" required=\"true\">\n" +
                "    <option value=\"UBC\" selected=\"selected\">UBC Vancouver</option>\n" +
                "    <option value=\"UBCO\">UBC Okanagan</option>\n" +
                "\n" +
                "\n" +
                "</select>\n" +
                "\n" +
                "</span> </div>\n" +
                "\t</div>\n" +
                "\t\n" +
                "\t\n" +
                "\t<div id=\"wwgrp_yearsessionlist\" class=\"wwgrp\">\n" +
                "<span id=\"wwlbl_yearsessionlist\" class=\"wwlbl\">\n" +
                "<label for=\"yearsessionlist\" class=\"label\">        Year/Session:\n" +
                "</label></span> <span id=\"wwctrl_yearsessionlist\" class=\"wwctrl\">\n" +
                "    \n" +
                "<select name=\"yearsession\" id=\"yearsessionlist\" onchange=\"getTerms();\" required=\"true\">\n" +
                "    <option value=\"\"></option>\n" +
                "\n" +
                "\n" +
                "</select>\n" +
                "\n" +
                "</span> </div>\t\n" +
                "\t\n" +
                "\t<div id=\"d_term\" class=\"hiddentext\">\n" +
                "\t\n" +
                "\t<div id=\"wwgrp_termlist\" class=\"wwgrp\">\n" +
                "<span id=\"wwlbl_termlist\" class=\"wwlbl\">\n" +
                "<label for=\"termlist\" class=\"label\">        Term:\n" +
                "</label></span> <span id=\"wwctrl_termlist\" class=\"wwctrl\">\n" +
                "    \n" +
                "<select name=\"term\" id=\"termlist\" onchange=\"getSubjects();\" required=\"true\">\n" +
                "    <option value=\"\"></option>\n" +
                "\n" +
                "\n" +
                "</select>\n" +
                "\n" +
                "</span> </div>\t\t\n" +
                "\t</div>\t\t\n" +
                "\t\n" +
                "\t<div id=\"d_subject\" class=\"hiddentext\">\n" +
                "\t\n" +
                "\t<div id=\"wwgrp_subjectlist\" class=\"wwgrp\">\n" +
                "<span id=\"wwlbl_subjectlist\" class=\"wwlbl\">\n" +
                "<label for=\"subjectlist\" class=\"label\">        Course subject:\n" +
                "</label></span> <span id=\"wwctrl_subjectlist\" class=\"wwctrl\">\n" +
                "    \n" +
                "<select name=\"subject\" id=\"subjectlist\" onchange=\"getCourses();\" required=\"true\">\n" +
                "    <option value=\"\"></option>\n" +
                "\n" +
                "\n" +
                "</select>\n" +
                "\n" +
                "</span> </div>\t\t\n" +
                "\t</div>\n" +
                "\t\t\t\n" +
                "\t<div id=\"d_course\" class=\"hiddentext\">\n" +
                "\t\n" +
                "\t<div id=\"wwgrp_courselist\" class=\"wwgrp\">\n" +
                "<span id=\"wwlbl_courselist\" class=\"wwlbl\">\n" +
                "<label for=\"courselist\" class=\"label\">        Course #:\n" +
                "</label></span> <span id=\"wwctrl_courselist\" class=\"wwctrl\">\n" +
                "    \n" +
                "<select name=\"course\" id=\"courselist\" onchange=\"getDetails();\">\n" +
                "    <option value=\"\"></option>\n" +
                "\n" +
                "\n" +
                "</select>\n" +
                "\n" +
                "</span> </div>\t\n" +
                "\t\n" +
                "\t\n" +
                "\t<div id=\"wwgrp_detaillist\" class=\"wwgrp\">\n" +
                "<span id=\"wwlbl_detaillist\" class=\"wwlbl\">\n" +
                "<label for=\"detaillist\" class=\"label\">        Detail:\n" +
                "</label></span> <span id=\"wwctrl_detaillist\" class=\"wwctrl\">\n" +
                "    \n" +
                "<select name=\"detail\" id=\"detaillist\" onchange=\"getSections();\">\n" +
                "    <option value=\"\"></option>\n" +
                "\n" +
                "\n" +
                "</select>\n" +
                "\n" +
                "</span> </div>\t\t\n" +
                "\t</div>\n" +
                "\t\n" +
                "\t<div id=\"d_section\" class=\"hiddentext\">\n" +
                "\t\n" +
                "\t<div id=\"wwgrp_sectionlist\" class=\"wwgrp\">\n" +
                "<span id=\"wwlbl_sectionlist\" class=\"wwlbl\">\n" +
                "<label for=\"sectionlist\" class=\"label\">        Section #:\n" +
                "</label></span> <span id=\"wwctrl_sectionlist\" class=\"wwctrl\">\n" +
                "    \n" +
                "<select name=\"section\" id=\"sectionlist\" onchange=\"\">\n" +
                "    <option value=\"\"></option>\n" +
                "\n" +
                "\n" +
                "</select>\n" +
                "\n" +
                "</span> </div>\t\n" +
                "\t</div>\t\n" +
                "\t\n" +
                "\t<div id=\"d_faculty\" class=\"hiddentext\">\n" +
                "\t<div id=\"wwgrp_facultylist\" class=\"wwgrp\">\n" +
                "<span id=\"wwlbl_facultylist\" class=\"wwlbl\">\n" +
                "<label for=\"facultylist\" class=\"label\">        Faculty:\n" +
                "</label></span> <span id=\"wwctrl_facultylist\" class=\"wwctrl\">\n" +
                "    \n" +
                "<select name=\"facultylist\" id=\"facultylist\" onchange=\"document.reportform.faculty.value=document.reportform.facultylist.value;getDepts();\">\n" +
                "    <option value=\"\"></option>\n" +
                "\n" +
                "\n" +
                "</select>\n" +
                "\n" +
                "</span> </div>\n" +
                "\t</div>\n" +
                "\t\t\n" +
                "\t<div id=\"d_dept\" class=\"hiddentext\">\n" +
                "\t<div id=\"wwgrp_deptlist\" class=\"wwgrp\">\n" +
                "<span id=\"wwlbl_deptlist\" class=\"wwlbl\">\n" +
                "<label for=\"deptlist\" class=\"label\">        Department:\n" +
                "</label></span> <span id=\"wwctrl_deptlist\" class=\"wwctrl\">\n" +
                "    \n" +
                "<select name=\"deptlist\" id=\"deptlist\" onchange=\"document.reportform.dept.value=document.reportform.deptlist.value;\">\n" +
                "    <option value=\"\"></option>\n" +
                "\n" +
                "\n" +
                "</select>\n" +
                "\n" +
                "</span> </div>\n" +
                "\t</div>\n" +
                "\t\n" +
                "\t<div id=\"d_email\" class=\"hiddentext\">\n" +
                "\t<br/><br/>\n" +
                "\t<p>\n" +
                "\tData extraction and processing can take a long time. Enter an email address. We will send you the results.\n" +
                "\t</p>\n" +
                "\t\n" +
                "\t<div id=\"wwgrp_email\" class=\"wwgrp\">\n" +
                "<span id=\"wwlbl_email\" class=\"wwlbl\">\n" +
                "<label for=\"email\" class=\"label\">        E-mail:\n" +
                "</label></span> <span id=\"wwctrl_email\" class=\"wwctrl\">\n" +
                "    \n" +
                "<input type=\"text\" name=\"email\" size=\"50\" maxlength=\"100\" value=\"\" id=\"email\"/></span> </div>\n" +
                "\t\n" +
                "\t<div id=\"wwgrp_gradesdist_runreport_format\" class=\"wwgrp\">\n" +
                "<span id=\"wwlbl_gradesdist_runreport_format\" class=\"wwlbl\">\n" +
                "<label for=\"gradesdist_runreport_format\" class=\"label\">        Format:\n" +
                "</label></span> <span id=\"wwctrl_gradesdist_runreport_format\" class=\"wwctrl\">\n" +
                "    \n" +
                "<input type=\"radio\" name=\"format\" id=\"gradesdist_runreport_formatCSV\" value=\"CSV\"/><label for=\"gradesdist_runreport_formatCSV\">CSV</label>\n" +
                "<input type=\"radio\" name=\"format\" id=\"gradesdist_runreport_formatHTML\" checked=\"checked\" value=\"HTML\"/><label for=\"gradesdist_runreport_formatHTML\">HTML</label>\n" +
                "</span> </div>\n" +
                "\n" +
                "\t</div>\n" +
                "\n" +
                "\t<br/><br/>\n" +
                "\t<img src=\"/reports/images/captcha.jpg\" border=\"0\" />\n" +
                "\t\n" +
                "\t<div id=\"wwgrp_txtcaptchal\" class=\"wwgrp\">\n" +
                "<span id=\"wwlbl_txtcaptchal\" class=\"wwlbl\">\n" +
                "<label for=\"txtcaptchal\" class=\"label\">        Enter displayed characters:\n" +
                "</label></span> <span id=\"wwctrl_txtcaptchal\" class=\"wwctrl\">\n" +
                "    \n" +
                "<input type=\"text\" name=\"captcha\" size=\"6\" maxlength=\"6\" value=\"\" id=\"txtcaptchal\" required=\"true\"/></span> </div>\n" +
                "\t\n" +
                "\t<br/><br/>\n" +
                "\t\n" +
                "\t<div align=\"left\"    id=\"wwctrl_gradesdist_runreport_0\"><input type=\"submit\" id=\"gradesdist_runreport_0\" value=\"Submit\"/>\n" +
                "</div> <br/>\t\t\n" +
                "\n" +
                "</form>\n" +
                "\n" +
                "\n" +
                "\n" +
                " \n" +
                "\n" +
                "<script type=\"text/javascript\" src=\"/reports/dwr/interface/sisservice.js\"></script>\n" +
                "<script type=\"text/javascript\" src=\"/reports/dwr/engine.js\"></script>\n" +
                "<script type=\"text/javascript\" src=\"/reports/dwr/util.js\"></script>\n" +
                "\n" +
                "<script type=\"text/javascript\">\n" +
                "\treporttype = 'SECTION';\n" +
                "\tinit();\n" +
                "\t\n" +
                "\tfunction init() \n" +
                "\t{\t\t\t\t\n" +
                "\t\t//DWRUtil.useLoadingMessage();\t \n" +
                "\t\tshowform();\n" +
                "\t}\t\t\n" +
                "\t\n" +
                "\tfunction useLoadingMessage(message) \n" +
                "\t{\n" +
                "\t  var loadingMessage;\n" +
                "\t  if ( message ) \n" +
                "\t  \tloadingMessage = message;\n" +
                "\t  else \n" +
                "\t  \tloadingMessage = \"Loading data ... please wait\";\n" +
                "\t\n" +
                "\t  dwr.engine.setPreHook(function() {\n" +
                "\t    var disabledZone = $('disabledZone');\n" +
                "\t    if (!disabledZone) {\n" +
                "\t      disabledZone = document.createElement('div');\n" +
                "\t      disabledZone.setAttribute('id', 'disabledZone');\n" +
                "\t      disabledZone.style.position = \"absolute\";\n" +
                "\t      disabledZone.style.zIndex = \"1000\";\n" +
                "\t      disabledZone.style.left = \"0px\";\n" +
                "\t      disabledZone.style.top = \"0px\";\n" +
                "\t      disabledZone.style.width = \"100%\";\n" +
                "\t      disabledZone.style.height = \"100%\";\n" +
                "\t      document.body.appendChild(disabledZone);\n" +
                "\t      \n" +
                "\t      var messageZone = document.createElement('div');\n" +
                "\t      messageZone.setAttribute('id', 'messageZone');\n" +
                "\t      messageZone.style.position = \"absolute\";\n" +
                "\t      messageZone.style.top = \"0px\";\n" +
                "\t      messageZone.style.right = \"0px\";\n" +
                "\t      messageZone.style.background = \"red\";\n" +
                "\t      messageZone.style.color = \"white\";\n" +
                "\t      messageZone.style.fontFamily = \"Arial,Helvetica,sans-serif\";\n" +
                "\t      messageZone.style.padding = \"4px\";\n" +
                "\t      disabledZone.appendChild(messageZone);\n" +
                "\t      var text = document.createTextNode(loadingMessage);\n" +
                "\t      messageZone.appendChild(text);\n" +
                "\t    }\n" +
                "\t    else \n" +
                "\t    {\n" +
                "\t      $('messageZone').innerHTML = loadingMessage;\n" +
                "\t      disabledZone.style.visibility = 'visible';\n" +
                "\t    }\n" +
                "\t  });\n" +
                "\t\n" +
                "\t  dwr.engine.setPostHook(function() {\n" +
                "\t    $('disabledZone').style.visibility = 'hidden';\n" +
                "\t  });\n" +
                "\t}\t\t\n" +
                "\t\n" +
                "\tfunction showform()\n" +
                "\t{\n" +
                "\t\treporttype = getCheckedValue( document.reportform.reporttype );\n" +
                "\t\t\n" +
                "\t\tif ( reporttype == 'SECTION' )\n" +
                "\t\t{\n" +
                "\t\t\thideDIV( \"d_email\" );\n" +
                "\t\t\texpandDIV( \"d_campus\" );\n" +
                "\t\t\thideDIV( \"d_term\" );\n" +
                "\t\t\texpandDIV( \"d_subject\" );\n" +
                "\t\t\texpandDIV( \"d_course\" );\n" +
                "\t\t\texpandDIV( \"d_section\" );\n" +
                "\t\t\thideDIV( \"d_admin\" );\n" +
                "\t\t\thideDIV( \"d_dept\" );\n" +
                "\t\t\thideDIV( \"d_faculty\" );\n" +
                "\t\t\t\n" +
                "\t\t\tgetYears();\n" +
                "\t\t}\n" +
                "\t\t\n" +
                "\t\tif ( reporttype == 'SUBJECT' )\n" +
                "\t\t{\n" +
                "\t\t\texpandDIV( \"d_campus\" );\n" +
                "\t\t\texpandDIV( \"d_email\" );\n" +
                "\t\t\texpandDIV( \"d_subject\" );\n" +
                "\t\t\thideDIV( \"d_term\" );\n" +
                "\t\t\thideDIV( \"d_course\" );\n" +
                "\t\t\thideDIV( \"d_section\" );\n" +
                "\t\t\thideDIV( \"d_admin\" );\n" +
                "\t\t\thideDIV( \"d_dept\" );\n" +
                "\t\t\thideDIV( \"d_faculty\" );\n" +
                "\t\t\t\n" +
                "\t\t\tgetYears();\n" +
                "\t\t}\t\n" +
                "\t\t\n" +
                "\t\tif ( reporttype == 'COURSE' )\n" +
                "\t\t{\n" +
                "\t\t\texpandDIV( \"d_campus\" );\n" +
                "\t\t\texpandDIV( \"d_email\" );\n" +
                "\t\t\texpandDIV( \"d_subject\" );\n" +
                "\t\t\texpandDIV( \"d_course\" );\n" +
                "\t\t\thideDIV( \"d_section\" );\n" +
                "\t\t\thideDIV( \"d_term\" );\n" +
                "\t\t\thideDIV( \"d_admin\" );\n" +
                "\t\t\thideDIV( \"d_dept\" );\n" +
                "\t\t\thideDIV( \"d_faculty\" );\n" +
                "\t\t\t\n" +
                "\t\t\tgetYears();\n" +
                "\t\t}\t\n" +
                "\t\t\n" +
                "\t\tif ( reporttype == 'STUDENT' )\n" +
                "\t\t{\n" +
                "\t\t\thideDIV( \"d_campus\" );\n" +
                "\t\t\texpandDIV( \"d_email\" );\n" +
                "\t\t\thideDIV( \"d_subject\" );\n" +
                "\t\t\thideDIV( \"d_term\" );\n" +
                "\t\t\thideDIV( \"d_course\" );\n" +
                "\t\t\thideDIV( \"d_section\" );\n" +
                "\t\t\thideDIV( \"d_admin\" );\n" +
                "\t\t\thideDIV( \"d_dept\" );\n" +
                "\t\t\thideDIV( \"d_faculty\" );\n" +
                "\t\t\t\n" +
                "\t\t\tgetGradesYears();\n" +
                "\t\t}\t\n" +
                "\t\t\n" +
                "\t\tif ( reporttype == 'ASTUDENT' )\n" +
                "\t\t{\n" +
                "\t\t\thideDIV( \"d_campus\" );\n" +
                "\t\t\texpandDIV( \"d_email\" );\n" +
                "\t\t\thideDIV( \"d_subject\" );\n" +
                "\t\t\thideDIV( \"d_term\" );\n" +
                "\t\t\thideDIV( \"d_course\" );\n" +
                "\t\t\thideDIV( \"d_section\" );\n" +
                "\t\t\texpandDIV( \"d_admin\" );\n" +
                "\t\t\thideDIV( \"d_dept\" );\n" +
                "\t\t\thideDIV( \"d_faculty\" );\n" +
                "\t\t\t\n" +
                "\t\t\tif ( document.reportform.stud_no.value != '' )\n" +
                "\t\t\t{\n" +
                "\t\t\t\tgetStudentGradesYears();\n" +
                "\t\t\t}\n" +
                "\t\t\telse\n" +
                "\t\t\t\tclearGradesYears();\n" +
                "\t\t}\t\t\n" +
                "\t\t\n" +
                "\t\tif ( reporttype == 'DEPT' )\n" +
                "\t\t{\n" +
                "\t\t\texpandDIV( \"d_campus\" );\n" +
                "\t\t\texpandDIV( \"d_email\" );\n" +
                "\t\t\thideDIV( \"d_subject\" );\n" +
                "\t\t\thideDIV( \"d_term\" );\n" +
                "\t\t\thideDIV( \"d_course\" );\n" +
                "\t\t\thideDIV( \"d_section\" );\n" +
                "\t\t\thideDIV( \"d_admin\" );\n" +
                "\t\t\texpandDIV( \"d_dept\" );\n" +
                "\t\t\texpandDIV( \"d_faculty\" );\n" +
                "\t\t\t\n" +
                "\t\t\tgetYears();\n" +
                "\t\t}\t\n" +
                "\t\t\n" +
                "\t\tif ( reporttype == 'FACULTY' )\n" +
                "\t\t{\n" +
                "\t\t\texpandDIV( \"d_campus\" );\n" +
                "\t\t\texpandDIV( \"d_email\" );\n" +
                "\t\t\thideDIV( \"d_subject\" );\n" +
                "\t\t\thideDIV( \"d_term\" );\n" +
                "\t\t\thideDIV( \"d_course\" );\n" +
                "\t\t\thideDIV( \"d_section\" );\n" +
                "\t\t\thideDIV( \"d_admin\" );\n" +
                "\t\t\thideDIV( \"d_dept\" );\n" +
                "\t\t\texpandDIV( \"d_faculty\" );\n" +
                "\n" +
                "\t\t\tgetYears();\n" +
                "\t\t}\t\t\n" +
                "\t\t\n" +
                "\t\tif ( reporttype == 'FACULTY' || reporttype == 'DEPT' )\n" +
                "\t\t{\n" +
                "\t\t\tgetFaculties();\n" +
                "\t\t}\n" +
                "\t}\n" +
                "\t\t\n" +
                "\tfunction getYears()\n" +
                "\t{\n" +
                "\t    sisservice.getYearsessions( document.reportform.campus.value, createYearList );\t    \n" +
                "\t}\n" +
                "\t\n" +
                "\tfunction getGradesYears()\n" +
                "\t{\n" +
                "\t\tsisservice.getGradesYearsessions( createYearList );\t   \n" +
                "\t}\n" +
                "\t\n" +
                "\tfunction clearStudent()\n" +
                "\t{\n" +
                "\t\tdocument.reportform.stud_no.value = '';\n" +
                "\t}\n" +
                "\t\n" +
                "\tfunction clearGradesYears()\n" +
                "\t{\n" +
                "\t\tDWRUtil.removeAllOptions( \"yearsessionlist\" );\n" +
                "\t}\n" +
                "\t\n" +
                "\tfunction getStudentGradesYears()\n" +
                "\t{\n" +
                "\t\tsisservice.getStudentGradesYearsessions( document.reportform.stud_no.value, createYearList );\t   \n" +
                "\t}\n" +
                "\t\n" +
                "\tfunction createYearList(data)\n" +
                "\t{\n" +
                "\t    DWRUtil.removeAllOptions( \"yearsessionlist\" );\n" +
                "\t    DWRUtil.addOptions( \"yearsessionlist\", data, \"value\", \"label\" );\n" +
                "\t\n" +
                "\t    // Get a reference to the dept drop-down\n" +
                "\t    var myDropdownList = document.reportform.yearsession;\n" +
                "\t\n" +
                "\t    itemToSelect = \"2014W\";\n" +
                "\t\n" +
                "\t    // Loop through all the items\n" +
                "\t    for (iLoop = 0; iLoop < myDropdownList.options.length; iLoop++)\n" +
                "\t    {\n" +
                "\t      if ( myDropdownList.options[iLoop].value == itemToSelect )\n" +
                "\t      {\n" +
                "\t        // Item is found. Set its selected property, and exit the loop\n" +
                "\t        myDropdownList.options[iLoop].selected = true;\n" +
                "\t        break;\n" +
                "\t      }\n" +
                "\t    }\n" +
                "\n" +
                "\t\treporttype = getCheckedValue( document.reportform.reporttype );\n" +
                "\t\tif ( reporttype == \"SECTION\" )\n" +
                "\t \t\tgetTerms();\n" +
                "\t \telse\n" +
                "\t \t\tgetSubjects();\n" +
                "\t}\n" +
                "\t\n" +
                "\tfunction getTerms()\n" +
                "\t{\n" +
                "\t\tys = document.reportform.yearsession.value; \n" +
                "\t\tif ( ys.length >= 5 )\n" +
                "\t\t{\n" +
                "\t\t\tyear = ys.substring( 0, 4 );\n" +
                "\t\t\tsession = ys.substring( 4 );\n" +
                "\n" +
                "\t\t\tsisservice.getTerms( document.reportform.campus.value, year, session, createTermList );\t \n" +
                "\t\t}\t\t    \n" +
                "\t}\n" +
                "\t\n" +
                "\tfunction createTermList(data)\n" +
                "\t{\n" +
                "\t    DWRUtil.removeAllOptions( \"termlist\" );\n" +
                "\t    DWRUtil.addOptions( \"termlist\", data, \"value\", \"label\" );\n" +
                "\t\n" +
                "\t    // Get a reference to the dept drop-down\n" +
                "\t    var myDropdownList = document.reportform.term;\n" +
                "\t\n" +
                "\t    itemToSelect = \" \";\n" +
                "\t\n" +
                "\t    // Loop through all the items\n" +
                "\t    for (iLoop = 0; iLoop < myDropdownList.options.length; iLoop++)\n" +
                "\t    {\n" +
                "\t      if ( myDropdownList.options[iLoop].value == itemToSelect )\n" +
                "\t      {\n" +
                "\t        // Item is found. Set its selected property, and exit the loop\n" +
                "\t        myDropdownList.options[iLoop].selected = true;\n" +
                "\t        break;\n" +
                "\t      }\n" +
                "\t    }\n" +
                "\n" +
                "\t \tgetSubjects();\n" +
                "\t}\t\n" +
                "\t\n" +
                "\tfunction getSubjects()\n" +
                "\t{\n" +
                "\t\tDWRUtil.removeAllOptions( \"subjectlist\" );\n" +
                "\t\t\n" +
                "\t\treporttype = getCheckedValue( document.reportform.reporttype );\n" +
                "\t\tif ( reporttype != \"SECTION\" )\n" +
                "\t\t\tterm = null;\n" +
                "\t\telse\n" +
                "\t\t\tterm = document.reportform.term.value;\n" +
                "\t\t\n" +
                "\t\tsisservice.getSubjects( document.reportform.campus.value, \n" +
                "\t\t\tdocument.reportform.yearsession.value, \n" +
                "\t\t\tterm, \n" +
                "\t\t\tnull, null, \n" +
                "\t\t\tcreateSubjectList );\t\t\t\n" +
                "\t}\t\n" +
                "\t\n" +
                "\tfunction createSubjectList( data )\n" +
                "\t{    \t\n" +
                "    \tDWRUtil.addOptions( \"subjectlist\", data, \"value\", \"label\" );\n" +
                "    \t\n" +
                "\t    // Get a reference to the faculty drop-down\n" +
                "\t    var myDropdownList = document.reportform.subject;\n" +
                "\t\n" +
                "\t    itemToSelect = \"BIOF\";\n" +
                "\t    \n" +
                "\t    // Loop through all the items\n" +
                "\t    for (iLoop = 0; iLoop< myDropdownList.options.length; iLoop++)\n" +
                "\t    {\n" +
                "\t      if ( myDropdownList.options[iLoop].value == itemToSelect )\n" +
                "\t      {\n" +
                "\t        // Item is found. Set its selected property, and exit the loop\n" +
                "\t        myDropdownList.options[iLoop].selected = true;\n" +
                "\t        break;\n" +
                "\t      }\n" +
                "\t    }   \n" +
                "\t    \n" +
                "\t    getCourses();\n" +
                "\t}\n" +
                "\t\n" +
                "\tfunction getCourses()\n" +
                "\t{\n" +
                "\t\tsisservice.getCourses( \n" +
                "\t\t\tdocument.reportform.campus.value, \n" +
                "\t\t\tdocument.reportform.yearsession.value,  \n" +
                "\t\t\tnull,\n" +
                "\t\t\tnull, \n" +
                "\t\t\tnull, \n" +
                "\t\t\tdocument.reportform.subject.value, \n" +
                "\t\t\tcreateCourseList );\n" +
                "\t}\n" +
                "\t\n" +
                "\tfunction createCourseList( data )\n" +
                "\t{\n" +
                "\t    DWRUtil.removeAllOptions( \"courselist\" );\n" +
                "\t    DWRUtil.addOptions( \"courselist\", data, \"value\", \"label\" );\n" +
                "\t\n" +
                "\t    // Get a reference to the dept drop-down\n" +
                "\t    var myDropdownList = document.reportform.course;\n" +
                "\t\n" +
                "\t    itemToSelect = \"520\";\n" +
                "\t\n" +
                "\t    // Loop through all the items\n" +
                "\t    for (iLoop = 0; iLoop < myDropdownList.options.length; iLoop++)\n" +
                "\t    {\n" +
                "\t      if ( myDropdownList.options[iLoop].value == itemToSelect )\n" +
                "\t      {\n" +
                "\t        // Item is found. Set its selected property, and exit the loop\n" +
                "\t        myDropdownList.options[iLoop].selected = true;\n" +
                "\t        break;\n" +
                "\t      }\n" +
                "\t    }\n" +
                "\t    \n" +
                "\t    document.reportform.course.value = document.reportform.courselist.value;\n" +
                "\t\n" +
                "\t \tgetDetails();\t\t\n" +
                "\t}\t\n" +
                "\t\n" +
                "\tfunction getDetails()\n" +
                "\t{\n" +
                "\t\tsisservice.getDetails( document.reportform.campus.value, document.reportform.yearsession.value, \n" +
                "\t\t\tdocument.reportform.subject.value, document.reportform.course.value, createDetailList );\n" +
                "\t}\n" +
                "\t\n" +
                "\tfunction createDetailList( data )\n" +
                "\t{\n" +
                "\t    DWRUtil.removeAllOptions( \"detaillist\" );\n" +
                "\t    DWRUtil.addOptions( \"detaillist\", data, \"value\", \"label\" );\n" +
                "\t\n" +
                "\t    // Get a reference to the dept drop-down\n" +
                "\t    var myDropdownList = document.reportform.detaillist;\n" +
                "\t\n" +
                "\t    itemToSelect = \" \";\n" +
                "\t\n" +
                "\t    // Loop through all the items\n" +
                "\t    for (iLoop = 0; iLoop < myDropdownList.options.length; iLoop++)\n" +
                "\t    {\n" +
                "\t      if ( myDropdownList.options[iLoop].value == itemToSelect )\n" +
                "\t      {\n" +
                "\t        // Item is found. Set its selected property, and exit the loop\n" +
                "\t        myDropdownList.options[iLoop].selected = true;\n" +
                "\t        break;\n" +
                "\t      }\n" +
                "\t    }\n" +
                "\t\n" +
                "\t \tgetSections();\t\t\n" +
                "\t}\t\n" +
                "\t\n" +
                "\tfunction getSections()\n" +
                "\t{\n" +
                "\t\tsisservice.getSections( document.reportform.campus.value, \n" +
                "\t\t\tdocument.reportform.yearsession.value, \n" +
                "\t\t\tdocument.reportform.subject.value, \n" +
                "\t\t\tdocument.reportform.course.value, \n" +
                "\t\t\tdocument.reportform.detail.value, \n" +
                "\t\t\tcreateSectionList );\n" +
                "\t}\n" +
                "\t\n" +
                "\tfunction createSectionList( data )\n" +
                "\t{\n" +
                "\t    DWRUtil.removeAllOptions(\"sectionlist\");\n" +
                "\t    DWRUtil.addOptions(\"sectionlist\", data, \"value\", \"label\" );\n" +
                "\t\n" +
                "\t    // Get a reference to the dept drop-down\n" +
                "\t    var myDropdownList = document.reportform.sectionlist;\n" +
                "\t\n" +
                "\t    itemToSelect = \"002\";\n" +
                "\t\n" +
                "\t    // Loop through all the items\n" +
                "\t    for (iLoop = 0; iLoop < myDropdownList.options.length; iLoop++)\n" +
                "\t    {\n" +
                "\t      if ( myDropdownList.options[iLoop].value == itemToSelect )\n" +
                "\t      {\n" +
                "\t        // Item is found. Set its selected property, and exit the loop\n" +
                "\t        myDropdownList.options[iLoop].selected = true;\n" +
                "\t        break;\n" +
                "\t      }\n" +
                "\t    }\n" +
                "\t}\t\n" +
                "\t\n" +
                "\tfunction getFaculties()\n" +
                "\t{\n" +
                "\t\tcampus = document.reportform.campus.value;\n" +
                "\t\t\n" +
                "\t\tsisservice.getFaculties( \n" +
                "\t\t\t\tcampus,\n" +
                "\t\t\t\tcreateFacultyList );\n" +
                "\t}\n" +
                "\t\n" +
                "\tfunction createFacultyList( data )\n" +
                "\t{\t\t    \n" +
                "\t    DWRUtil.removeAllOptions( \"facultylist\" ); \n" +
                "\t    DWRUtil.addOptions( \"facultylist\", data, \"value\", \"label\" );\n" +
                "\t\n" +
                "\t    // Get a reference to the drop-down\n" +
                "\t    var myDropdownList = document.reportform.facultylist;\n" +
                "\t\n" +
                "\t    itemToSelect = document.reportform.faculty.value;\n" +
                "\t    \n" +
                "\t    // Loop through all the items\n" +
                "\t    for (iLoop = 0; iLoop< myDropdownList.options.length; iLoop++)\n" +
                "\t    {\n" +
                "\t      if ( myDropdownList.options[iLoop].value == itemToSelect )\n" +
                "\t      {\n" +
                "\t        // Item is found. Set its selected property, and exit the loop\n" +
                "\t        myDropdownList.options[iLoop].selected = true;\n" +
                "\t        break;\n" +
                "\t      }\n" +
                "\t    }\t   \n" +
                "\t    \n" +
                "\t    if ( document.reportform.faculty.value == '' )\n" +
                "\t    \t document.reportform.faculty.value = document.reportform.facultylist.value;\t\t\n" +
                "\n" +
                "\t\tgetDepts();\n" +
                "\t}\n" +
                "\t\n" +
                "\tfunction getDepts()\n" +
                "\t{\n" +
                "\t\tcampus = document.reportform.campus.value;\n" +
                "\t\tfaculty = document.reportform.faculty.value;\n" +
                "\t\tsisservice.getDepts( \n" +
                "\t\t\t\tcampus,\n" +
                "\t\t\t\tfaculty,\n" +
                "\t\t\t\tcreateDeptList );\n" +
                "\t}\n" +
                "\t\n" +
                "\tfunction createDeptList( data )\n" +
                "\t{\t\t    \n" +
                "\t    DWRUtil.removeAllOptions( \"deptlist\" ); \n" +
                "\t    DWRUtil.addOptions( \"deptlist\", data, \"value\", \"label\" );\n" +
                "\t\n" +
                "\t    // Get a reference to the drop-down\n" +
                "\t    var myDropdownList = document.reportform.deptlist;\n" +
                "\t\n" +
                "\t    itemToSelect = document.reportform.dept.value;\n" +
                "\t    \n" +
                "\t    // Loop through all the items\n" +
                "\t    for (iLoop = 0; iLoop< myDropdownList.options.length; iLoop++)\n" +
                "\t    {\n" +
                "\t      if ( myDropdownList.options[iLoop].value == itemToSelect )\n" +
                "\t      {\n" +
                "\t        // Item is found. Set its selected property, and exit the loop\n" +
                "\t        myDropdownList.options[iLoop].selected = true;\n" +
                "\t        break;\n" +
                "\t      }\n" +
                "\t    }\t   \n" +
                "\t    \n" +
                "\t    if ( document.reportform.dept.value == '' )\n" +
                "\t    \t document.reportform.dept.value = document.reportform.deptlist.value;\t\t\n" +
                "\n" +
                "\t}\n" +
                "\n" +
                "</script>\n" +
                "\n" +
                "\n" +
                "\t\n" +
                "\t<p>\n" +
                "<strong>Note</strong>:  UBC's grading policy requires that all partial grades be submitted \n" +
                "regardless of whether students complete the course.  Therefore, grades less \n" +
                "than 40% may be due to students who did not write the final exam and who did \n" +
                "not withdraw from the course.\t\n" +
                "\t</p><br/><br/>\n" +
                "\t<table border=\"0\" cellpadding=\"3\" cellspacing=\"3\">\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td>Instructor</td>\n" +
                "\t\t\t<td colspan=\"6\">Birol, Inanc;Brinkman, Ryan;Cherkasov, Artem;Jones, Steven J;Shah, Sohrab</td>\n" +
                "\t\t</tr>\n" +
                "\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td>Year/session</td>\n" +
                "\t\t\t<td colspan=\"6\">2014</td>\n" +
                "\t\t</tr>\n" +
                "\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td>Course Subject</td>\n" +
                "\t\t\t<td colspan=\"6\">BIOF</td>\n" +
                "\t\t</tr>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td>Course #</td>\n" +
                "\t\t\t<td colspan=\"6\">520</td>\n" +
                "\t\t</tr>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td>Detail</td>\n" +
                "\t\t\t<td colspan=\"6\"> </td>\n" +
                "\t\t</tr>\t\t\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td>Section #</td>\n" +
                "\t\t\t<td colspan=\"6\">002</td>\n" +
                "\t\t</tr>\n" +
                "\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td>Title</td>\n" +
                "\t\t\t<td colspan=\"6\">PROB-BSD LRN BIO</td>\n" +
                "\t\t</tr>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td>Enrolled</td>\n" +
                "\t\t\t<td colspan=\"6\">16</td>\n" +
                "\t\t</tr>\n" +
                "\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td colspan=\"7\">&nbsp;</td>\n" +
                "\t\t</tr>\n" +
                "\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td>Average</td>\n" +
                "\t\t\t<td>Standard deviation</td>\n" +
                "\t\t\t<td>High</td>\n" +
                "\t\t\t<td>Low</td>\n" +
                "\t\t\t<td>Pass</td>\n" +
                "\t\t\t<td>Fail</td>\n" +
                "\t\t\t<td>Withdrew</td>\n" +
                "\t\t\t<td>Other</td>\n" +
                "\t\t</tr>\n" +
                "\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td colspan=\"7\">&nbsp;</td>\n" +
                "\t\t</tr>\n" +
                "\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td>88.31</td>\n" +
                "\t\t\t<td>3.89</td>\n" +
                "\t\t\t<td>95</td>\n" +
                "\t\t\t<td>79</td>\n" +
                "\t\t\t<td>16</td>\n" +
                "\t\t\t<td>0</td>\n" +
                "\t\t\t<td>0</td>\n" +
                "\t\t\t<td>0</td>\n" +
                "\t\t</tr>\n" +
                "\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td colspan=\"7\">&nbsp;</td>\n" +
                "\t\t</tr>\n" +
                "\t\t\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td>0-9%</td>\n" +
                "\t\t\t<td colspan=\"6\">0</td>\n" +
                "\t\t</tr>\n" +
                "\t\t\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td>10-19%</td>\n" +
                "\t\t\t<td colspan=\"6\">0</td>\n" +
                "\t\t</tr>\n" +
                "\t\t\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td>20-29%</td>\n" +
                "\t\t\t<td colspan=\"6\">0</td>\n" +
                "\t\t</tr>\n" +
                "\t\t\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td>30-39%</td>\n" +
                "\t\t\t<td colspan=\"6\">0</td>\n" +
                "\t\t</tr>\n" +
                "\t\t\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td>40-49%</td>\n" +
                "\t\t\t<td colspan=\"6\">0</td>\n" +
                "\t\t</tr>\n" +
                "\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td>&lt;50%</td>\n" +
                "\t\t\t<td colspan=\"6\">0</td>\n" +
                "\t\t</tr>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td>50-54%</td>\n" +
                "\t\t\t<td colspan=\"6\">0</td>\n" +
                "\t\t</tr>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td>55-59%</td>\n" +
                "\t\t\t<td colspan=\"6\">0</td>\n" +
                "\t\t</tr>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td>60-63%</td>\n" +
                "\t\t\t<td colspan=\"6\">0</td>\n" +
                "\t\t</tr>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td>64-67%</td>\n" +
                "\t\t\t<td colspan=\"6\">0</td>\n" +
                "\t\t</tr>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td>68-71%</td>\n" +
                "\t\t\t<td colspan=\"6\">0</td>\n" +
                "\t\t</tr>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td>72-75%</td>\n" +
                "\t\t\t<td colspan=\"6\">0</td>\n" +
                "\t\t</tr>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td>76-79%</td>\n" +
                "\t\t\t<td colspan=\"6\">1</td>\n" +
                "\t\t</tr>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td>80-84%</td>\n" +
                "\t\t\t<td colspan=\"6\">1</td>\n" +
                "\t\t</tr>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td>85-89%</td>\n" +
                "\t\t\t<td colspan=\"6\">8</td>\n" +
                "\t\t</tr>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td>90-100%</td>\n" +
                "\t\t\t<td colspan=\"6\">6</td>\n" +
                "\t\t</tr>\n" +
                "\t</table>\t\n" +
                "\t\n" +
                "\n" +
                "\n" +
                "</div>\n" +
                "\n" +
                "<div class=\"panel\">\n" +
                "\n" +
                "<div id=\"primary\" class=\"aside\">\n" +
                "\n" +
                "<div id=\"olt-subpages-navigation-widget-3\"\n" +
                "\tclass=\"widget widget_subpages_navigation widget-widget_subpages_navigation\">\n" +
                "\t\n" +
                "<div class=\"widget-inside\">\n" +
                "<h3 class=\"widget-title\">Navigation</h3>\n" +
                "<ul\n" +
                "\tclass=\"subpages-navi subpages-navi-widget subpages-navi-exclusive subpages-navi-collapsible subpages-navi-auto-expand\">\n" +
                "\n" +
                "\t\n" +
                "\t<li class=\"subpages-navi-node subpages-navi-level-0\"><a\thref=\"/reports/logout.action\">Logout</a></li>\n" +
                "\t\n" +
                "\t\n" +
                "\t<li class=\"subpages-navi-node subpages-navi-level-0 subpages-navi-current-level\">\n" +
                "\t<a href=\"/reports/\">Home</a>\n" +
                "\t</li>\n" +
                "\t\n" +
                "\t\n" +
                "<!-- \n" +
                "\n" +
                "-->\n" +
                "\n" +
                "\n" +
                "\n" +
                "\t\n" +
                "\t\n" +
                "\n" +
                "<!-- \t\n" +
                "\t\n" +
                "\t<li class=\"subpages-navi-node subpages-navi-level-0\"><a\thref=\"http://www.ombudsoffice.ubc.ca/\">Office of the Ombudsperson for Students</a>\n" +
                "\t<ul class='children'>\n" +
                "\t\t\n" +
                "\t\t<li class=\"subpages-navi-node subpages-navi-level-1\">\n" +
                "\t\t\t<a href=\"/reports/forms_request.action?formname=ombudstudent20090727\">Student Online Request for Assistance</a>\n" +
                "\t\t</li>\n" +
                "\t\t\n" +
                "\t\t\n" +
                "\t\t\n" +
                "\t</ul>\t\t\n" +
                "\t</li>\n" +
                "\t\n" +
                "-->\t\t\n" +
                "\t\n" +
                "\t\t\t\n" +
                "\t<li class=\"subpages-navi-node subpages-navi-level-0\"><a\thref=\"http://www.students.ubc.ca/\">SIS Reports</a>\n" +
                "\t<ul class='children'>\n" +
                "\t\t<li class=\"subpages-navi-node subpages-navi-level-1\"><a\thref=\"/reports/autoreport_request.action?reportname=cs\" title=\"Classrooms and Space\">Classrooms and Space</a>\n" +
                "\t\t</li>\n" +
                "\n" +
                "\t\t<li class=\"subpages-navi-node subpages-navi-level-1\"><a href=\"/reports/crsdist_request.action\">Course Distribution Report</a></li>\n" +
                "\t\t<li class=\"subpages-navi-node subpages-navi-level-1\"><a href=\"/reports/enrl_request.action\">Course Enrollment Report</a></li>\n" +
                "\t\t<li class=\"subpages-navi-node subpages-navi-level-1\"><a href=\"/reports/degreeprofile_request.action\">Degree Profile Report</a></li>\n" +
                "\t\t\n" +
                "\t\t<li class=\"subpages-navi-node subpages-navi-level-1\"><a href=\"/reports/gradesdist_request.action\">Grades Distribution Report</a></li>\n" +
                "\t\t\t\n" +
                "\t\t\n" +
                "\t</ul>\n" +
                "\t</li>\t\n" +
                "\t\n" +
                "\t\n" +
                "</ul>\n" +
                "\n" +
                "</div>\n" +
                "</div>\n" +
                "\n" +
                "\n" +
                "<div id=\"linkcat-711\" class=\"widget bookmarks widget-bookmarks\">\n" +
                "<div class=\"widget-inside\">\n" +
                "<h3 class=\"widget-title\">Related Links</h3>\n" +
                "<ul class='xoxo blogroll'>\n" +
                "\t<li><a href=\"http://www.pair.ubc.ca\" onclick=\"window.open(this.href); return false;\" onkeypress=\"window.open(this.href); return false;\"><span>Planning &amp; Institutional Research web site</span></a></li>\n" +
                "</ul>\n" +
                "</div>\n" +
                "</div>\n" +
                "</div>\n" +
                "\n" +
                "</div><!-- panel --> \n" +
                "\n" +
                "</div><!-- #container -->\n" +
                "\n" +
                "<div id=\"footer-container\">\n" +
                "\n" +
                "\n" +
                "<div id=\"footer\" style=\"padding-left: 0px;\"><p style=\"font-size:80%;\">Best viewed with Mozilla Firefox or Internet Explorer 8.\n" +
                "In Internet Explorer, please turn off Compatibility View.</p></div>\n" +
                "<!-- #footer --></div>\n" +
                "<!-- #footer-container --></div>\n" +
                "<!-- #body-container -->\n" +
                "\n" +
                "<!-- END: UBC CLF CONTENT SPACE -->\n" +
                "<!-- BEGIN: UBC CLF FOOTER -->\n" +
                "<!-- BEGIN: UBC CLF VISUAL IDENTITY FOOTER -->\n" +
                "<div id=\"UbcBottomInfoWrapper\">\n" +
                "<div id=\"UbcBottomInfo\" class=\"UbcContainer\">\n" +
                "\n" +
                "<div id=\"UbcBottomLeft\">\n" +
                "<p><a href=\"http://www.ubc.ca\"><img src=\"/reports/_ubc_clf/img/footer/logo.gif\" alt=\"a place of mind, The University of British Columbia\" /></a></p>\n" +
                "</div>\n" +
                "<!-- End UbcBottomLeft -->\n" +
                "<div id=\"UbcBottomCenter\">\n" +
                "</div>\n" +
                "<!-- End UbcBottomCenter -->\n" +
                "<div id=\"UbcBottomRight\">\n" +
                "<p>UBC Planning &amp; Institutional Research<br/>\n" +
                "6328 Memorial Road<br/>\n" +
                "Vancouver, BC Canada V6T 1Z2\n" +
                "</p>\n" +
                "\n" +
                "<br />\n" +
                "</div>\n" +
                "<!-- End UbcBottomRight --></div>\n" +
                "<!-- End UbcBottomInfo UbcContainer --></div>\n" +
                "<!-- End UbcBottomInfoWrapper -->\n" +
                "<!-- END: UBC CLF VISUAL IDENTITY FOOTER -->\n" +
                "<!-- BEGIN: UBC CLF GLOBAL UTILITY FOOTER -->\n" +
                "<div id=\"UbcUtilNavWrapper\">\n" +
                "<div id=\"UbcUtilNav\" class=\"UbcContainer\">\n" +
                "<p><a href=\"http://www.emergency.ubc.ca/\">Emergency Procedures</a>&nbsp;|&nbsp;<a\n" +
                "\thref=\"http://www.ubc.ca/accessibility/\">Accessibility</a>&nbsp;|&nbsp;<a\n" +
                "\thref=\"http://www.ubc.ca/about/contact/\">Contact UBC</a>&nbsp;|&nbsp;<a\n" +
                "\thref=\"http://www.ubc.ca/copyright/\">&copy; Copyright The University\n" +
                "of British Columbia</a></p>\n" +
                "\n" +
                "</div>\n" +
                "<!-- End UbcUtilNav UbcContainer --></div>\n" +
                "<!-- End UbcUtilNavWrapper -->\n" +
                "<!-- END: UBC CLF GLOBAL UTILITY FOOTER -->\n" +
                "<!-- END: UBC CLF FOOTER -->\n" +
                "\n" +
                "</body>\n" +
                "</html>\n" +
                "\n";
    }


    @Test
    public void testCreateFromFile() throws Exception {
        SectionFactory.createFromFile(new File("/Users/vpineda1996/file.data"));
        System.out.println(SectionFactory.getInstance());
    }

    @Test
    public void testSaveToFile() throws Exception {

        SectionFactory.getInstance().parseSectionFromHTTPRequest(grdResponse);
        SectionFactory.getInstance().parseSectionFromHTTPRequest(grdResponse2);
        SectionFactory.getInstance().saveToFile(new File("/Users/vpineda1996/file.data"));
    }
}