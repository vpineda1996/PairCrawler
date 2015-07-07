package me.vpineda.request.test;

import me.vpineda.request.CourseFactory;
import me.vpineda.request.CourseSubject;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by vpineda1996 on 2015-05-18.
 */
public class CourseSubjectFactoryTest {
    public String serverResponse;
    @Before
    public void setUp() throws Exception {
        serverResponse  = "throw 'allowScriptTagRemoting is false.';\n" +
                "//#DWR-INSERT\n" +
                "//#DWR-REPLY\n" +
                "var s0={};var s1={};var s2={};var s3={};var s4={};var s5={};var s6={};var s7={};var s8={};var s9={};var s10={};var s11={};var s12={};var s13={};var s14={};var s15={};var s16={};var s17={};var s18={};var s19={};var s20={};var s21={};var s22={};var s23={};var s24={};var s25={};var s26={};var s27={};var s28={};var s29={};var s30={};var s31={};var s32={};var s33={};var s34={};var s35={};var s36={};var s37={};var s38={};var s39={};var s40={};var s41={};var s42={};var s43={};var s44={};var s45={};var s46={};var s47={};var s48={};var s49={};var s50={};var s51={};var s52={};var s53={};var s54={};var s55={};var s56={};var s57={};var s58={};var s59={};var s60={};var s61={};var s62={};var s63={};var s64={};var s65={};var s66={};var s67={};var s68={};var s69={};var s70={};var s71={};var s72={};var s73={};var s74={};var s75={};var s76={};var s77={};var s78={};var s79={};var s80={};var s81={};var s82={};var s83={};var s84={};var s85={};var s86={};var s87={};var s88={};var s89={};var s90={};var s91={};var s92={};var s93={};var s94={};var s95={};var s96={};var s97={};var s98={};var s99={};var s100={};var s101={};var s102={};var s103={};var s104={};var s105={};var s106={};var s107={};var s108={};var s109={};var s110={};var s111={};var s112={};var s113={};var s114={};var s115={};var s116={};var s117={};var s118={};var s119={};var s120={};var s121={};var s122={};var s123={};var s124={};var s125={};var s126={};var s127={};var s128={};var s129={};var s130={};var s131={};var s132={};var s133={};var s134={};var s135={};var s136={};var s137={};var s138={};var s139={};var s140={};var s141={};var s142={};var s143={};var s144={};var s145={};var s146={};var s147={};var s148={};var s149={};var s150={};var s151={};var s152={};var s153={};var s154={};var s155={};var s156={};var s157={};var s158={};var s159={};var s160={};var s161={};var s162={};var s163={};var s164={};var s165={};var s166={};var s167={};var s168={};var s169={};var s170={};var s171={};var s172={};var s173={};var s174={};var s175={};var s176={};var s177={};var s178={};var s179={};var s180={};var s181={};var s182={};var s183={};var s184={};var s185={};var s186={};var s187={};var s188={};var s189={};var s190={};var s191={};var s192={};var s193={};var s194={};var s195={};var s196={};var s197={};var s198={};var s199={};var s200={};var s201={};var s202={};var s203={};var s204={};var s205={};var s206={};var s207={};var s208={};var s209={};var s210={};var s211={};var s212={};var s213={};var s214={};var s215={};var s216={};s0.label=\"\";s0.value=\"\";\n" +
                "s1.label=\"AANB - APPLIED ANIMAL BIOLOGY\";s1.value=\"AANB\";\n" +
                "s2.label=\"ADHE - ADULT AND HIGHER EDUCATON\";s2.value=\"ADHE\";\n" +
                "s3.label=\"AFST - AFRICAN STUDIES\";s3.value=\"AFST\";\n" +
                "s4.label=\"AGEC - AGRICULTURAL ECON\";s4.value=\"AGEC\";\n" +
                "s5.label=\"ANAE - ANESTHESIA\";s5.value=\"ANAE\";\n" +
                "s6.label=\"ANAT - ANATOMY\";s6.value=\"ANAT\";\n" +
                "s7.label=\"ANSC - ANIMAL SCIENCE\";s7.value=\"ANSC\";\n" +
                "s8.label=\"ANTH - ANTHROPOLOGY\";s8.value=\"ANTH\";\n" +
                "s9.label=\"APBI - APPLIED BIOLOGY\";s9.value=\"APBI\";\n" +
                "s10.label=\"APSC - APPLIED SCIENCE\";s10.value=\"APSC\";\n" +
                "s11.label=\"ARBC - ARABIC STUDIES\";s11.value=\"ARBC\";\n" +
                "s12.label=\"ARCH - ARCHITECTURE\";s12.value=\"ARCH\";\n" +
                "s13.label=\"ARCL - ANTHRO ARCHAEOLOGY\";s13.value=\"ARCL\";\n" +
                "s14.label=\"ARST - ARCHIVAL STUDIES\";s14.value=\"ARST\";\n" +
                "s15.label=\"ARTH - ART HISTORY\";s15.value=\"ARTH\";\n" +
                "s16.label=\"ARTS - ARTS ONE\";s16.value=\"ARTS\";\n" +
                "s17.label=\"ASIA - ASIAN STUDIES\";s17.value=\"ASIA\";\n" +
                "s18.label=\"ASIC - ARTS AND SCIENCE INTERDISC\";s18.value=\"ASIC\";\n" +
                "s19.label=\"ASTR - ASTRONOMY\";s19.value=\"ASTR\";\n" +
                "s20.label=\"ASTU - ARTS STUDIES\";s20.value=\"ASTU\";\n" +
                "s21.label=\"ATSC - ATMOSPHERIC SC\";s21.value=\"ATSC\";\n" +
                "s22.label=\"AUDI - AUDIOL AND SPEECH SC\";s22.value=\"AUDI\";\n" +
                "s23.label=\"BA   - BUSINESS ADMINISTRATION: CORE\";s23.value=\"BA  \";\n" +
                "s24.label=\"BAAC - ACCOUNTING\";s24.value=\"BAAC\";\n" +
                "s25.label=\"BABS - BUSINESS ADMIN. - STATS\";s25.value=\"BABS\";\n" +
                "s26.label=\"BAEN - BUSINESS ADMIN - ENTREPREN.\";s26.value=\"BAEN\";\n" +
                "s27.label=\"BAFI - BUSINESS ADMIN - FINANCE\";s27.value=\"BAFI\";\n" +
                "s28.label=\"BAHR - BUSINESS ADMIN- HR MANAGEMENT\";s28.value=\"BAHR\";\n" +
                "s29.label=\"BAIT - BUSINESS ADMIN-BUSI TECH MGMT\";s29.value=\"BAIT\";\n" +
                "s30.label=\"BALA - BUSINESS ADMIN - LAW\";s30.value=\"BALA\";\n" +
                "s31.label=\"BAMA - BUSINESS ADMIN - MARKETING\";s31.value=\"BAMA\";\n" +
                "s32.label=\"BAMS - BUSINESS ADMIN. MGMT SCIENCE\";s32.value=\"BAMS\";\n" +
                "s33.label=\"BAPA - BUSINESS ADMIN.POLICY ANALYSIS\";s33.value=\"BAPA\";\n" +
                "s34.label=\"BASC - BUSINESS ADMIN - SUPPLY CHAIN\";s34.value=\"BASC\";\n" +
                "s35.label=\"BASM - BUSINESS ADMIN.STRATEGIC MGMT\";s35.value=\"BASM\";\n" +
                "s36.label=\"BAUL - BUSINESS ADMIN.URBAN LAND ECON\";s36.value=\"BAUL\";\n" +
                "s37.label=\"BIOC - BIOCHEMISTRY\";s37.value=\"BIOC\";\n" +
                "s38.label=\"BIOF - BIOINFORMATICS\";s38.value=\"BIOF\";\n" +
                "s39.label=\"BIOL - BIOLOGY\";s39.value=\"BIOL\";\n" +
                "s40.label=\"BIOT - BIOTECHNOLOGY\";s40.value=\"BIOT\";\n" +
                "s41.label=\"BMEG - BIOMEDICAL ENGINEERING\";s41.value=\"BMEG\";\n" +
                "s42.label=\"BOTA - BOTANY\";s42.value=\"BOTA\";\n" +
                "s43.label=\"BRDG - BRIDGE PROGRAM\";s43.value=\"BRDG\";\n" +
                "s44.label=\"BUSI - BUSINESS\";s44.value=\"BUSI\";\n" +
                "s45.label=\"CAPS - CELL, ANATOM & PHYL SCIENCES\";s45.value=\"CAPS\";\n" +
                "s46.label=\"CCFI - CNTR FOR CROSS-FACULTY INQUIRY\";s46.value=\"CCFI\";\n" +
                "s47.label=\"CCST - CRITICAL & CURATORIAL STUDIES\";s47.value=\"CCST\";\n" +
                "s48.label=\"CDST - CANADIAN STUDIES\";s48.value=\"CDST\";\n" +
                "s49.label=\"CEEN - CLEAN ENERGY ENGINEERING\";s49.value=\"CEEN\";\n" +
                "s50.label=\"CELL - CELL AND DEVELOPMENTAL BIOLOGY\";s50.value=\"CELL\";\n" +
                "s51.label=\"CENS - CENTRAL,EAST & N.EUR.STUDIES\";s51.value=\"CENS\";\n" +
                "s52.label=\"CHBE - CHEM & BIOLOGICAL ENG\";s52.value=\"CHBE\";\n" +
                "s53.label=\"CHEM - CHEMISTRY\";s53.value=\"CHEM\";\n" +
                "s54.label=\"CHIL - CHILDREN\\'S LITERATURE\";s54.value=\"CHIL\";\n" +
                "s55.label=\"CHIN - CHINESE\";s55.value=\"CHIN\";\n" +
                "s56.label=\"CICS - COMP INFO & COGNITIVE SYSTEMS\";s56.value=\"CICS\";\n" +
                "s57.label=\"CIVL - CIVIL ENG\";s57.value=\"CIVL\";\n" +
                "s58.label=\"CLCH - CLASSICAL CHINESE\";s58.value=\"CLCH\";\n" +
                "s59.label=\"CLST - CLASSICAL STUDIES\";s59.value=\"CLST\";\n" +
                "s60.label=\"CNPS - COUNSELLING PSYC\";s60.value=\"CNPS\";\n" +
                "s61.label=\"CNRS - CLASS,N.EASTERN & RELG.STUDIES\";s61.value=\"CNRS\";\n" +
                "s62.label=\"COGS - COGNITIVE SYSTEMS PROGRAM\";s62.value=\"COGS\";\n" +
                "s63.label=\"COHR - COMMERCE HUMAN RESOURCES\";s63.value=\"COHR\";\n" +
                "s64.label=\"COMM - COMMERCE\";s64.value=\"COMM\";\n" +
                "s65.label=\"CONS - NATURAL RESOURCES CONSERVATION\";s65.value=\"CONS\";\n" +
                "s66.label=\"CPSC - COMPUTER SCIENCE\";s66.value=\"CPSC\";\n" +
                "s67.label=\"CRWR - CREATIVE WRITING\";s67.value=\"CRWR\";\n" +
                "s68.label=\"CSIS - CRITICAL STUDIES IN SEXUALITY\";s68.value=\"CSIS\";\n" +
                "s69.label=\"CSPW - Coord Science Program Workshop\";s69.value=\"CSPW\";\n" +
                "s70.label=\"DANI - DANISH\";s70.value=\"DANI\";\n" +
                "s71.label=\"DENT - DENTISTRY\";s71.value=\"DENT\";\n" +
                "s72.label=\"DERM - CLINICAL DERMATOLOGY\";s72.value=\"DERM\";\n" +
                "s73.label=\"DHYG - DENTAL HYGIENE\";s73.value=\"DHYG\";\n" +
                "s74.label=\"DPAS - DOCTOR/DENTIST,PATIENT & SOC\";s74.value=\"DPAS\";\n" +
                "s75.label=\"ECED - EARLY CHILDHOOD ED\";s75.value=\"ECED\";\n" +
                "s76.label=\"ECON - ECONOMICS\";s76.value=\"ECON\";\n" +
                "s77.label=\"EDCP - CURRICULUM AND PEDAGOGY\";s77.value=\"EDCP\";\n" +
                "s78.label=\"EDST - EDUCATIONAL STUDIES\";s78.value=\"EDST\";\n" +
                "s79.label=\"EDUC - EDUCATION\";s79.value=\"EDUC\";\n" +
                "s80.label=\"EECE - ELECTRICAL & COMPUTING ENG\";s80.value=\"EECE\";\n" +
                "s81.label=\"ELI  - ENGLISH LANGUAGE INSTITUTE\";s81.value=\"ELI \";\n" +
                "s82.label=\"EMBA - EXECUTIVE M.B.A.\";s82.value=\"EMBA\";\n" +
                "s83.label=\"EMER - EMERGENCY MEDICINE\";s83.value=\"EMER\";\n" +
                "s84.label=\"ENDS - ENVIRONMENTAL DESIGN\";s84.value=\"ENDS\";\n" +
                "s85.label=\"ENGL - ENGLISH\";s85.value=\"ENGL\";\n" +
                "s86.label=\"ENPH - ENG PHYSICS\";s86.value=\"ENPH\";\n" +
                "s87.label=\"ENVR - ENVIRONMENTAL SCIENCE\";s87.value=\"ENVR\";\n" +
                "s88.label=\"EOSC - EARTH AND OCEAN SCIENCES\";s88.value=\"EOSC\";\n" +
                "s89.label=\"EPSE - ED PSYC & SPEC ED\";s89.value=\"EPSE\";\n" +
                "s90.label=\"ETEC - EDUCATIONAL TECHNOLOGY\";s90.value=\"ETEC\";\n" +
                "s91.label=\"EXCH - EXCHANGE\";s91.value=\"EXCH\";\n" +
                "s92.label=\"EXGR - EXCHANGE GRADUATE RESEARCH\";s92.value=\"EXGR\";\n" +
                "s93.label=\"FEBC - FOREST ENGINEERING BC\";s93.value=\"FEBC\";\n" +
                "s94.label=\"FHIS - FREN, HISP AND ITAL STUDIES\";s94.value=\"FHIS\";\n" +
                "s95.label=\"FIPR - FILM PRODUCTION\";s95.value=\"FIPR\";\n" +
                "s96.label=\"FISH - FISHERIES\";s96.value=\"FISH\";\n" +
                "s97.label=\"FIST - FILM STUDIES\";s97.value=\"FIST\";\n" +
                "s98.label=\"FMED - FOUNDATIONS OF MED\";s98.value=\"FMED\";\n" +
                "s99.label=\"FMPR - FAMILY PRACTICE\";s99.value=\"FMPR\";\n" +
                "s100.label=\"FMST - FAMILY STUDIES\";s100.value=\"FMST\";\n" +
                "s101.label=\"FNH  - FOOD, NUTRITION AND HEALTH\";s101.value=\"FNH \";\n" +
                "s102.label=\"FNLG - FIRST NATIONS LANGUAGES\";s102.value=\"FNLG\";\n" +
                "s103.label=\"FNSP - First Nations Studies Program\";s103.value=\"FNSP\";\n" +
                "s104.label=\"FOOD - FOOD SCIENCE\";s104.value=\"FOOD\";\n" +
                "s105.label=\"FOPR - FOREST OPERATIONS\";s105.value=\"FOPR\";\n" +
                "s106.label=\"FRE  - FOOD AND RESOURCE ECONOMICS\";s106.value=\"FRE \";\n" +
                "s107.label=\"FREN - FRENCH\";s107.value=\"FREN\";\n" +
                "s108.label=\"FRST - FORESTRY\";s108.value=\"FRST\";\n" +
                "s109.label=\"GENE - GENETICS\";s109.value=\"GENE\";\n" +
                "s110.label=\"GEOB - GEOGRAPHICAL BIOGEOSCIENCES\";s110.value=\"GEOB\";\n" +
                "s111.label=\"GEOG - GEOGRAPHY\";s111.value=\"GEOG\";\n" +
                "s112.label=\"GERM - GERMAN\";s112.value=\"GERM\";\n" +
                "s113.label=\"GREK - GREEK\";s113.value=\"GREK\";\n" +
                "s114.label=\"GRS  - GLOBAL RESOURCE SYSTEMS\";s114.value=\"GRS \";\n" +
                "s115.label=\"GRSJ - GENDER,RACE,SEXUALITY&SOC JUST\";s115.value=\"GRSJ\";\n" +
                "s116.label=\"GSAT - GENOME SCIENCE AND TECHNOLOGY\";s116.value=\"GSAT\";\n" +
                "s117.label=\"HEBR - HEBREW\";s117.value=\"HEBR\";\n" +
                "s118.label=\"HGSE - HAIDA GWAII SEMESTERS\";s118.value=\"HGSE\";\n" +
                "s119.label=\"HINU - HINDI-URDU\";s119.value=\"HINU\";\n" +
                "s120.label=\"HIST - HISTORY\";s120.value=\"HIST\";\n" +
                "s121.label=\"HUNU - HUMAN NUTRITION\";s121.value=\"HUNU\";\n" +
                "s122.label=\"IAR  - INSTITUTE OF ASIAN RESEARCH\";s122.value=\"IAR \";\n" +
                "s123.label=\"IGEN - INTEGRATED ENGINEERING\";s123.value=\"IGEN\";\n" +
                "s124.label=\"IHHS - INTERPROF.HEALTH/HUMAN SERV\";s124.value=\"IHHS\";\n" +
                "s125.label=\"INDE - INTERDEPART MED.\";s125.value=\"INDE\";\n" +
                "s126.label=\"INDS - INTERDISCIPLINE ST\";s126.value=\"INDS\";\n" +
                "s127.label=\"ISCI - INTEGRATED SCIENCES\";s127.value=\"ISCI\";\n" +
                "s128.label=\"ITAL - ITALIAN\";s128.value=\"ITAL\";\n" +
                "s129.label=\"ITST - ITALIAN STUDIES\";s129.value=\"ITST\";\n" +
                "s130.label=\"JAPN - JAPANESE\";s130.value=\"JAPN\";\n" +
                "s131.label=\"JRNL - JOURNALISM\";s131.value=\"JRNL\";\n" +
                "s132.label=\"KIN  - KINESIOLOGY\";s132.value=\"KIN \";\n" +
                "s133.label=\"KORN - KOREAN\";s133.value=\"KORN\";\n" +
                "s134.label=\"LARC - LANDSCAPE ARCHTCTR\";s134.value=\"LARC\";\n" +
                "s135.label=\"LASO - LAW AND SOCIETY\";s135.value=\"LASO\";\n" +
                "s136.label=\"LAST - LATIN AMERICAN STUDIES\";s136.value=\"LAST\";\n" +
                "s137.label=\"LATN - LATIN\";s137.value=\"LATN\";\n" +
                "s138.label=\"LAW  - LAW\";s138.value=\"LAW \";\n" +
                "s139.label=\"LFS  - LAND & FOOD SYSTEMS\";s139.value=\"LFS \";\n" +
                "s140.label=\"LIBE - TEACHER LIBRARIANSHIP\";s140.value=\"LIBE\";\n" +
                "s141.label=\"LIBR - LIBRARIANSHIP\";s141.value=\"LIBR\";\n" +
                "s142.label=\"LING - LINGUISTICS\";s142.value=\"LING\";\n" +
                "s143.label=\"LLED - LANG & LITERACY ED\";s143.value=\"LLED\";\n" +
                "s144.label=\"MATH - MATHEMATICS\";s144.value=\"MATH\";\n" +
                "s145.label=\"MDVL - MEDIEVAL STUDIES\";s145.value=\"MDVL\";\n" +
                "s146.label=\"MECH - MECHANICAL ENG\";s146.value=\"MECH\";\n" +
                "s147.label=\"MEDG - MEDICAL GENETICS\";s147.value=\"MEDG\";\n" +
                "s148.label=\"MEDI - MEDICINE\";s148.value=\"MEDI\";\n" +
                "s149.label=\"MICB - MICROBIOLOGY\";s149.value=\"MICB\";\n" +
                "s150.label=\"MIDW - MIDWIFERY\";s150.value=\"MIDW\";\n" +
                "s151.label=\"MINE - MINING ENGINEERING\";s151.value=\"MINE\";\n" +
                "s152.label=\"MRNE - MARINE SCIENCE\";s152.value=\"MRNE\";\n" +
                "s153.label=\"MTRL - MATERIALS ENGINEERING\";s153.value=\"MTRL\";\n" +
                "s154.label=\"MUSC - MUSIC\";s154.value=\"MUSC\";\n" +
                "s155.label=\"NAME - NAVAL ARCH & MARINE DESIGN\";s155.value=\"NAME\";\n" +
                "s156.label=\"NEST - NEAR EASTERN STUDIES\";s156.value=\"NEST\";\n" +
                "s157.label=\"NRSC - NEUROSCIENCE\";s157.value=\"NRSC\";\n" +
                "s158.label=\"NURS - NURSING\";s158.value=\"NURS\";\n" +
                "s159.label=\"OBST - OBSTET & GYNAE\";s159.value=\"OBST\";\n" +
                "s160.label=\"ONCO - ONCOLOGY\";s160.value=\"ONCO\";\n" +
                "s161.label=\"OPTH - OPHTHALMOLOGY\";s161.value=\"OPTH\";\n" +
                "s162.label=\"ORNT - ORNT\";s162.value=\"ORNT\";\n" +
                "s163.label=\"ORPA - ORTHOPAEDICS\";s163.value=\"ORPA\";\n" +
                "s164.label=\"PAED - PAEDIATRICS\";s164.value=\"PAED\";\n" +
                "s165.label=\"PATH - PATHOLOGY\";s165.value=\"PATH\";\n" +
                "s166.label=\"PCTH - PHARMCLGY&THERPTCS\";s166.value=\"PCTH\";\n" +
                "s167.label=\"PERS - PERSIAN\";s167.value=\"PERS\";\n" +
                "s168.label=\"PHAR - PHARMACEUTICAL SCI\";s168.value=\"PHAR\";\n" +
                "s169.label=\"PHIL - PHILOSOPHY\";s169.value=\"PHIL\";\n" +
                "s170.label=\"PHTH - PHYSICAL THERAPY\";s170.value=\"PHTH\";\n" +
                "s171.label=\"PHYL - CELL & PHYL SCIENCES\";s171.value=\"PHYL\";\n" +
                "s172.label=\"PHYS - PHYSICS & ASTRONOMY\";s172.value=\"PHYS\";\n" +
                "s173.label=\"PLAN - PLANNING\";s173.value=\"PLAN\";\n" +
                "s174.label=\"PLNT - PLANT SCIENCE\";s174.value=\"PLNT\";\n" +
                "s175.label=\"POLI - POLITICAL SCIENCE\";s175.value=\"POLI\";\n" +
                "s176.label=\"POLS - POLISH\";s176.value=\"POLS\";\n" +
                "s177.label=\"PORT - PORTUGESE\";s177.value=\"PORT\";\n" +
                "s178.label=\"PRIN - PRIN\";s178.value=\"PRIN\";\n" +
                "s179.label=\"PSYC - PSYCHOLOGY\";s179.value=\"PSYC\";\n" +
                "s180.label=\"PSYT - PSYCHIATRY\";s180.value=\"PSYT\";\n" +
                "s181.label=\"PUNJ - PUNJABI\";s181.value=\"PUNJ\";\n" +
                "s182.label=\"RELG - RELIGIOUS STUDIES\";s182.value=\"RELG\";\n" +
                "s183.label=\"RGLA - RELG,LIT.& THE ARTS\";s183.value=\"RGLA\";\n" +
                "s184.label=\"RHSC - REHABILITATION SCIENCES\";s184.value=\"RHSC\";\n" +
                "s185.label=\"RMES - RES. MGN. & ENVIR. STUDIES\";s185.value=\"RMES\";\n" +
                "s186.label=\"RMST - ROMANCE STUDIES\";s186.value=\"RMST\";\n" +
                "s187.label=\"RSOT - REHAB SCIENCES OC THERAPY\";s187.value=\"RSOT\";\n" +
                "s188.label=\"RUSS - RUSSIAN\";s188.value=\"RUSS\";\n" +
                "s189.label=\"SANS - SANSKRIT\";s189.value=\"SANS\";\n" +
                "s190.label=\"SCAN - SCANDINAVIAN\";s190.value=\"SCAN\";\n" +
                "s191.label=\"SCIE - SCIENCE\";s191.value=\"SCIE\";\n" +
                "s192.label=\"SEAL - SOU EAST ASIAN LNG\";s192.value=\"SEAL\";\n" +
                "s193.label=\"SLAV - SLAVIC STUDIES\";s193.value=\"SLAV\";\n" +
                "s194.label=\"SOCI - SOCIOLOGY\";s194.value=\"SOCI\";\n" +
                "s195.label=\"SOIL - SOIL SCIENCE\";s195.value=\"SOIL\";\n" +
                "s196.label=\"SOWK - SOCIAL WORK\";s196.value=\"SOWK\";\n" +
                "s197.label=\"SPAN - SPANISH\";s197.value=\"SPAN\";\n" +
                "s198.label=\"SPHA - HEALTH ADMINISTRATION\";s198.value=\"SPHA\";\n" +
                "s199.label=\"SPPH - POPULATION & PUBLIC HEALTH\";s199.value=\"SPPH\";\n" +
                "s200.label=\"STAT - STATISTICS\";s200.value=\"STAT\";\n" +
                "s201.label=\"STS  - SCIENCE AND TECHNOLOGY STUDIES\";s201.value=\"STS \";\n" +
                "s202.label=\"SURG - SURGERY\";s202.value=\"SURG\";\n" +
                "s203.label=\"SWED - SWEDISH\";s203.value=\"SWED\";\n" +
                "s204.label=\"THTR - THEATRE\";s204.value=\"THTR\";\n" +
                "s205.label=\"TRSC - TRANSITION SCHOOL\";s205.value=\"TRSC\";\n" +
                "s206.label=\"UDES - URBAN DESIGN\";s206.value=\"UDES\";\n" +
                "s207.label=\"URST - URBAN STUDIES\";s207.value=\"URST\";\n" +
                "s208.label=\"VANT - VANTAGE COLLEGE\";s208.value=\"VANT\";\n" +
                "s209.label=\"VGRD - VISITING GRADUATE STUDENT\";s209.value=\"VGRD\";\n" +
                "s210.label=\"VISA - VISUAL ARTS\";s210.value=\"VISA\";\n" +
                "s211.label=\"VRHC - VOCATIONAL REHAB COUNSELLING\";s211.value=\"VRHC\";\n" +
                "s212.label=\"VURS - VISITING U.G. RES STDNTS\";s212.value=\"VURS\";\n" +
                "s213.label=\"WOOD - WOOD PRODUCTS PROCESSING\";s213.value=\"WOOD\";\n" +
                "s214.label=\"WRDS - ART STUDIES IN WRITING\";s214.value=\"WRDS\";\n" +
                "s215.label=\"WRIT - WRIT\";s215.value=\"WRIT\";\n" +
                "s216.label=\"ZOOL - ZOOLOGY\";s216.value=\"ZOOL\";\n" +
                "dwr.engine._remoteHandleCallback('2','0',[s0,s1,s2,s3,s4,s5,s6,s7,s8,s9,s10,s11,s12,s13,s14,s15,s16,s17,s18,s19,s20,s21,s22,s23,s24,s25,s26,s27,s28,s29,s30,s31,s32,s33,s34,s35,s36,s37,s38,s39,s40,s41,s42,s43,s44,s45,s46,s47,s48,s49,s50,s51,s52,s53,s54,s55,s56,s57,s58,s59,s60,s61,s62,s63,s64,s65,s66,s67,s68,s69,s70,s71,s72,s73,s74,s75,s76,s77,s78,s79,s80,s81,s82,s83,s84,s85,s86,s87,s88,s89,s90,s91,s92,s93,s94,s95,s96,s97,s98,s99,s100,s101,s102,s103,s104,s105,s106,s107,s108,s109,s110,s111,s112,s113,s114,s115,s116,s117,s118,s119,s120,s121,s122,s123,s124,s125,s126,s127,s128,s129,s130,s131,s132,s133,s134,s135,s136,s137,s138,s139,s140,s141,s142,s143,s144,s145,s146,s147,s148,s149,s150,s151,s152,s153,s154,s155,s156,s157,s158,s159,s160,s161,s162,s163,s164,s165,s166,s167,s168,s169,s170,s171,s172,s173,s174,s175,s176,s177,s178,s179,s180,s181,s182,s183,s184,s185,s186,s187,s188,s189,s190,s191,s192,s193,s194,s195,s196,s197,s198,s199,s200,s201,s202,s203,s204,s205,s206,s207,s208,s209,s210,s211,s212,s213,s214,s215,s216]);\n";
    }

    @Test
    public void testParseCourses() throws Exception {
        CourseFactory.getInstance().parseCourses(serverResponse);
        assertTrue(CourseFactory.getInstance().getCourseSubject("CPSC").equals(new CourseSubject(null,"CPSC")));
    }
}