drop table students cascade constraints;
drop table faculties_and_dorms cascade constraints;
drop table dorms cascade constraints;

SELECT first_name, last_name from students;
select * from students order by id;
select * from dorms;
select * from faculties_and_dorms;

update students set dorm_id = null where student_id = '393RQ4';


CREATE TABLE students (
  id NUMBER(10,0) NOT NULL PRIMARY KEY,
  student_id VARCHAR2(20) NOT NULL UNIQUE,
  faculty_name VARCHAR2(60) NOT NULL,
  first_name VARCHAR2(35),
  last_name VARCHAR2(35),
  average_grade NUMBER(4,2),
  email VARCHAR2(40),
  phone varchar2(15),
  gender VARCHAR2(10),
  preference1 VARCHAR2(15),
  preference2 VARCHAR2(15),
  preference3 VARCHAR2(15),
  preference4 VARCHAR2(15),
  preference5 VARCHAR2(15),
  preference6 VARCHAR2(15),
  dorm_id int
);


CREATE TABLE dorms (
    dorm_id int PRIMARY KEY,
    dorm_name VARCHAR(50),
    price NUMBER(3,0)); 
    
    
create table faculties_and_dorms(
    allocation_id NUMBER(3,0) primary key not null,
    faculty_name VARCHAR2(70),
    dorm_id NUMBER(3,0),
    girls_spots NUMBER(3,0),
    boys_spots NUMBER(3,0));


INSERT INTO dorms VALUES(1,'Akademos',400);
INSERT INTO dorms VALUES(2,'Gaudeaumus',360);
INSERT INTO dorms VALUES(3,'C1-C2-C3',500);
INSERT INTO dorms VALUES(4,'C6-C7-C8',270);
INSERT INTO dorms VALUES(5,'C11-C12-C13',510);
INSERT INTO dorms VALUES(6,'Bunavestire',320);

/
SET SERVEROUTPUT ON;
DECLARE

  
  TYPE varr IS VARRAY(1000) OF varchar2(100);
  names_list varr := varr('Ababei','Acasandrei','Adascalitei','Afanasie','Agafitei','Agape','Aioanei','Alexandrescu','Alexandru','Alexe','Alexii','Amarghioalei','Ambroci','Andonesei','Andrei','Andrian','Andrici','Andronic','Andros','Anghelina','Anita','Antochi','Antonie','Apetrei','Apostol','Arhip','Arhire','Arteni','Arvinte','Asaftei','Asofiei','Aungurenci','Avadanei','Avram','Babei','Baciu','Baetu','Balan','Balica','Banu','Barbieru','Barzu','Bazgan','Bejan','Bejenaru','Belcescu','Belciuganu','Benchea','Bilan','Birsanu','Bivol','Bizu','Boca','Bodnar','Boistean','Borcan','Bordeianu','Botezatu','Bradea','Braescu','Budaca','Bulai','Bulbuc-aioanei','Burlacu','Burloiu','Bursuc','Butacu','Bute','Buza','Calancea','Calinescu','Capusneanu','Caraiman','Carbune','Carp','Catana','Catiru','Catonoiu','Cazacu','Cazamir','Cebere','Cehan','Cernescu','Chelaru','Chelmu','Chelmus','Chibici','Chicos','Chilaboc','Chile','Chiriac','Chirila','Chistol','Chitic','Chmilevski','Cimpoesu','Ciobanu','Ciobotaru','Ciocoiu','Ciofu','Ciornei','Citea','Ciucanu','Clatinici','Clim','Cobuz','Coca','Cojocariu','Cojocaru','Condurache','Corciu','Corduneanu','Corfu','Corneanu','Corodescu','Coseru','Cosnita','Costan','Covatariu','Cozma','Cozmiuc','Craciunas','Crainiceanu','Creanga','Cretu','Cristea','Crucerescu','Cumpata','Curca','Cusmuliuc','Damian','Damoc','Daneliuc','Daniel','Danila','Darie','Dascalescu','Dascalu','Diaconu','Dima','Dimache','Dinu','Dobos','Dochitei','Dochitoiu','Dodan','Dogaru','Domnaru','Dorneanu','Dragan','Dragoman','Dragomir','Dragomirescu','Duceac','Dudau','Durnea','Edu','Eduard','Eusebiu','Fedeles','Ferestraoaru','Filibiu','Filimon','Filip','Florescu','Folvaiter','Frumosu','Frunza','Galatanu','Gavrilita','Gavriliuc','Gavrilovici','Gherase','Gherca','Ghergu','Gherman','Ghibirdic','Giosanu','Gitlan','Giurgila','Glodeanu','Goldan','Gorgan','Grama','Grigore','Grigoriu','Grosu','Grozavu','Gurau','Haba','Harabula','Hardon','Harpa','Herdes','Herscovici','Hociung','Hodoreanu','Hostiuc','Huma','Hutanu','Huzum','Iacob','Iacobuta','Iancu','Ichim','Iftimesei','Ilie','Insuratelu','Ionesei','Ionesi','Ionita','Iordache','Iordache-tiroiu','Iordan','Iosub','Iovu','Irimia','Ivascu','Jecu','Jitariuc','Jitca','Joldescu','Juravle','Larion','Lates','Latu','Lazar','Leleu','Leon','Leonte','Leuciuc','Leustean','Luca','Lucaci','Lucasi','Luncasu','Lungeanu','Lungu','Lupascu','Lupu','Macariu','Macoveschi','Maftei','Maganu','Mangalagiu','Manolache','Manole','Marcu','Marinov','Martinas','Marton','Mataca','Matcovici','Matei','Maties','Matrana','Maxim','Mazareanu','Mazilu','Mazur','Melniciuc-puica','Micu','Mihaela','Mihai','Mihaila','Mihailescu','Mihalachi','Mihalcea','Mihociu','Milut','Minea','Minghel','Minuti','Miron','Mitan','Moisa','Moniry-abyaneh','Morarescu','Morosanu','Moscu','Motrescu','Motroi','Munteanu','Murarasu','Musca','Mutescu','Nastaca','Nechita','Neghina','Negrus','Negruser','Negrutu','Nemtoc','Netedu','Nica','Nicu','Olanuta','Olarasu','Olariu','Olaru','Onu','Opariuc','Oprea','Ostafe','Otrocol','Palihovici','Pantiru','Pantiruc','Paparuz','Pascaru','Patachi','Patras','Patriche','Perciun','Perju','Petcu','Pila','Pintilie','Piriu','Platon','Plugariu','Podaru','Poenariu','Pojar','Popa','Popescu','Popovici','Poputoaia','Postolache','Predoaia','Prisecaru','Procop','Prodan','Puiu','Purice','Rachieru','Razvan','Reut','Riscanu','Riza','Robu','Roman','Romanescu','Romaniuc','Rosca','Rusu','Samson','Sandu','Sandulache','Sava','Savescu','Schifirnet','Scortanu','Scurtu','Sfarghiu','Silitra','Simiganoschi','Simion','Simionescu','Simionesei','Simon','Sitaru','Sleghel','Sofian','Soficu','Sparhat','Spiridon','Stan','Stavarache','Stefan','Stefanita','Stingaciu','Stiufliuc','Stoian','Stoica','Stoleru','Stolniceanu','Stolnicu','Strainu','Strimtu','Suhani','Tabusca','Talif','Tanasa','Teclici','Teodorescu','Tesu','Tifrea','Timofte','Tincu','Tirpescu','Toader','Tofan','Toma','Toncu','Trifan','Tudosa','Tudose','Tuduri','Tuiu','Turcu','Ulinici','Unghianu','Ungureanu','Ursache','Ursachi','Urse','Ursu','Varlan','Varteniuc','Varvaroi','Vasilache','Vasiliu','Ventaniuc','Vicol','Vidru','Vinatoru','Vlad','Voaides','Vrabie','Vulpescu','Zamosteanu','Zazuleac');
  girl_names varr := varr('Adina','Alexandra','Alina','Ana','Anca','Anda','Andra','Andreea','Andreia','Antonia','Bianca','Camelia','Claudia','Codrina','Cristina','Daniela','Daria','Delia','Denisa','Diana','Ecaterina','Elena','Eleonora','Elisa','Ema','Emanuela','Emma','Gabriela','Georgiana','Ileana','Ilona','Ioana','Iolanda','Irina','Iulia','Iuliana','Larisa','Laura','Loredana','Madalina','Malina','Manuela','Maria','Mihaela','Mirela','Monica','Oana','Paula','Petruta','Raluca','Sabina','Sanziana','Simina','Simona','Stefana','Stefania','Tamara','Teodora','Theodora','Vasilica','Xena');
  boy_names varr := varr('Adrian','Alex','Alexandru','Alin','Andreas','Andrei','Aurelian','Beniamin','Bogdan','Camil','Catalin','Cezar','Ciprian','Claudiu','Codrin','Constantin','Corneliu','Cosmin','Costel','Cristian','Damian','Dan','Daniel','Danut','Darius','Denise','Dimitrie','Dorian','Dorin','Dragos','Dumitru','Eduard','Elvis','Emil','Ervin','Eugen','Eusebiu','Fabian','Filip','Florian','Florin','Gabriel','George','Gheorghe','Giani','Giulio','Iaroslav','Ilie','Ioan','Ion','Ionel','Ionut','Iosif','Irinel','Iulian','Iustin','Laurentiu','Liviu','Lucian','Marian','Marius','Matei','Mihai','Mihail','Nicolae','Nicu','Nicusor','Octavian','Ovidiu','Paul','Petru','Petrut','Radu','Rares','Razvan','Richard','Robert','Roland','Rolland','Romanescu','Sabin','Samuel','Sebastian','Sergiu','Silviu','Stefan','Teodor','Teofil','Theodor','Tudor','Vadim','Valentin','Valeriu','Vasile','Victor','Vlad','Vladimir','Vladut');
  faculty_names varr := varr('Faculty of Biology', 'Faculty of Chemistry', 'Faculty of Computer Science', 'Faculty of Economics and Business Administration', 'Faculty of Geography and Geology',
            'Faculty of History', 'Faculty of Law', 'Faculty of Letters', 'Faculty of Mathematics', 'Faculty of Orthodox Theology', 'Faculty of Philosophy and Social-Political Sciences',
            'Faculty of Physical Education and Sport', 'Faculty of Physics', 'Faculty of Psychology and Educational Sciences', 'Faculty of Roman-Catholic Theology');
  dorms_list varr := varr('Akademos', 'Gaudeaumus', 'C1-C2-C3', 'C6-C7-C8', 'Bunavestire', 'C11-C12-C13');
  v_id NUMBER(10,0); 
  v_student_id VARCHAR2(20);
  v_faculty_name VARCHAR2(60);  
  v_last_name VARCHAR2(35);
  v_first_name VARCHAR2(35);
  v_average_grade NUMBER(4,2);
  v_email varchar2(40);
  v_phone VARCHAR2(15);
  v_gen	varchar2(10);
  v_temp int;
  v_preference1 varchar2(15);
  v_preference2 varchar2(15);
  v_preference3 varchar2(15);
  v_preference4 varchar2(15);
  v_preference5 varchar2(15);
  v_preference6 varchar2(15);
  v_dorm_id int := NULL;
  
  id1 NUMBER(3,0);
  i NUMBER(2,0);

BEGIN
  
   DBMS_OUTPUT.PUT_LINE('Inserarea a 1025 studenti...');

    
  id1 := 1; -- id repartizare
  FOR i IN 1..6 LOOP --id camin; nr. alocarii - adica alocarea 1 corespunde cu facultatea de biologie si caminul 1  
    INSERT INTO faculties_and_dorms (allocation_id, faculty_name, dorm_id, girls_spots, boys_spots) VALUES (id1, 'Faculty of Biology', i, ROUND(DBMS_RANDOM.VALUE(1, 10)), ROUND(DBMS_RANDOM.VALUE(1, 10)));
    id1 := id1+1;
  END LOOP;
  
  FOR i IN 1..6 LOOP --id camin
    INSERT INTO faculties_and_dorms (allocation_id, faculty_name, dorm_id, girls_spots, boys_spots) VALUES (id1,'Faculty of Chemistry' , i, ROUND(DBMS_RANDOM.VALUE(1, 10)), ROUND(DBMS_RANDOM.VALUE(1, 10)));
    id1 := id1+1;
  END LOOP;
  
  FOR i IN 1..6 LOOP
    INSERT INTO faculties_and_dorms (allocation_id, faculty_name, dorm_id, girls_spots, boys_spots) VALUES (id1, 'Faculty of Computer Science', i, ROUND(DBMS_RANDOM.VALUE(1, 10)), ROUND(DBMS_RANDOM.VALUE(1, 10)));
    id1 := id1+1;
  END LOOP;
  
  FOR i IN 1..6 LOOP
    INSERT INTO faculties_and_dorms (allocation_id, faculty_name, dorm_id, girls_spots, boys_spots) VALUES (id1,'Faculty of Economics and Business Administration', i, ROUND(DBMS_RANDOM.VALUE(1, 10)), ROUND(DBMS_RANDOM.VALUE(1, 10)));
    id1 := id1+1;
  END LOOP;
  
  FOR i IN 1..6 LOOP
    INSERT INTO faculties_and_dorms (allocation_id, faculty_name, dorm_id, girls_spots, boys_spots) VALUES (id1,'Faculty of Geography and Geology', i, ROUND(DBMS_RANDOM.VALUE(1, 10)), ROUND(DBMS_RANDOM.VALUE(1, 10)));
    id1 := id1+1;
  END LOOP;
  
  FOR i IN 1..6 LOOP
    INSERT INTO faculties_and_dorms (allocation_id, faculty_name, dorm_id, girls_spots, boys_spots) VALUES (id1,'Faculty of History', i, ROUND(DBMS_RANDOM.VALUE(1, 10)), ROUND(DBMS_RANDOM.VALUE(1, 10)));
    id1 := id1+1;
  END LOOP;
  
  FOR i IN 1..6 LOOP
    INSERT INTO faculties_and_dorms (allocation_id, faculty_name, dorm_id, girls_spots, boys_spots) VALUES (id1,'Faculty of Law', i, ROUND(DBMS_RANDOM.VALUE(1, 10)), ROUND(DBMS_RANDOM.VALUE(1, 10)));
    id1 := id1+1;
  END LOOP;
  
  FOR i IN 1..6 LOOP
    INSERT INTO faculties_and_dorms (allocation_id, faculty_name, dorm_id, girls_spots, boys_spots) VALUES (id1,'Faculty of Letters', i, ROUND(DBMS_RANDOM.VALUE(1, 10)), ROUND(DBMS_RANDOM.VALUE(1, 10)));
    id1 := id1+1;
  END LOOP;
  
  FOR i IN 1..6 LOOP
    INSERT INTO faculties_and_dorms (allocation_id, faculty_name, dorm_id, girls_spots, boys_spots) VALUES (id1,'Faculty of Mathematics', i, ROUND(DBMS_RANDOM.VALUE(1, 10)), ROUND(DBMS_RANDOM.VALUE(1, 10)));
    id1 := id1+1;
  END LOOP;
  
  FOR i IN 1..6 LOOP
    INSERT INTO faculties_and_dorms (allocation_id, faculty_name, dorm_id, girls_spots, boys_spots) VALUES (id1,'Faculty of Orthodox Theology', i, ROUND(DBMS_RANDOM.VALUE(1, 10)), ROUND(DBMS_RANDOM.VALUE(1, 10)));
    id1 := id1+1;
  END LOOP;
  
  FOR i IN 1..6 LOOP
    INSERT INTO faculties_and_dorms (allocation_id, faculty_name, dorm_id, girls_spots, boys_spots) VALUES (id1,'Faculty of Philosophy and Social-Political Sciences', i, ROUND(DBMS_RANDOM.VALUE(1, 10)), ROUND(DBMS_RANDOM.VALUE(1, 10)));
    id1 := id1+1;
  END LOOP;
  
  FOR i IN 1..6 LOOP
    INSERT INTO faculties_and_dorms (allocation_id, faculty_name, dorm_id, girls_spots, boys_spots) VALUES (id1,'Faculty of Physical Education and Sport', i, ROUND(DBMS_RANDOM.VALUE(1, 10)), ROUND(DBMS_RANDOM.VALUE(1, 10)));
    id1 := id1+1;
  END LOOP;
  
  FOR i IN 1..6 LOOP
    INSERT INTO faculties_and_dorms (allocation_id, faculty_name, dorm_id, girls_spots, boys_spots) VALUES (id1,'Faculty of Physics', i, ROUND(DBMS_RANDOM.VALUE(1, 10)), ROUND(DBMS_RANDOM.VALUE(1, 10)));
    id1 := id1+1;
  END LOOP;
  
  FOR i IN 1..6 LOOP
    INSERT INTO faculties_and_dorms (allocation_id, faculty_name, dorm_id, girls_spots, boys_spots) VALUES (id1,'Faculty of Psychology and Educational Sciences', i, ROUND(DBMS_RANDOM.VALUE(1, 10)), ROUND(DBMS_RANDOM.VALUE(1, 10)));
    id1 := id1+1;
  END LOOP;
  
  FOR i IN 1..6 LOOP
    INSERT INTO faculties_and_dorms (allocation_id, faculty_name, dorm_id, girls_spots, boys_spots) VALUES (id1,'Faculty of Roman-Catholic Theology', i, ROUND(DBMS_RANDOM.VALUE(1, 10)), ROUND(DBMS_RANDOM.VALUE(1,10)));
    id1 := id1+1;
  END LOOP;
  
   
   FOR v_id IN 1..1025 LOOP
      v_last_name := names_list(TRUNC(DBMS_RANDOM.VALUE(0,names_list.count))+1);
      IF (DBMS_RANDOM.VALUE(0,100)<50) THEN 
		 v_gen := 'Female';
         v_first_name := girl_names(TRUNC(DBMS_RANDOM.VALUE(0,girl_names.count))+1);
       ELSE
          v_gen := 'Male';
          v_first_name := boy_names(TRUNC(DBMS_RANDOM.VALUE(0,boy_names.count))+1);       
       END IF;     
       
      LOOP
         v_student_id := FLOOR(DBMS_RANDOM.VALUE(100,999)) || CHR(FLOOR(DBMS_RANDOM.VALUE(65,91))) || CHR(FLOOR(DBMS_RANDOM.VALUE(65,91))) || FLOOR(DBMS_RANDOM.VALUE(0,9));
         select count(*) into v_temp from students where v_student_id=student_id;
         exit when v_temp=0;
      END LOOP;
      
      v_temp:=0;
       LOOP
         v_phone := '07' || round(DBMS_RANDOM.VALUE(10000000,99999999));
         select count(*) into v_temp from students where v_phone=phone;
         exit when v_temp=0;
      END LOOP;
                
    v_average_grade := dbms_random.value(0.5,1)*10;
      
      
    v_email := lower(v_last_name ||'.'|| v_first_name ||'@gmail.com');
    
    v_faculty_name := faculty_names(round(dbms_random.value(1,15)));
    
    v_preference1 := dorms_list(ROUND(DBMS_RANDOM.VALUE(1,6)));
    v_temp:=0;
    LOOP
         v_preference2 := dorms_list(ROUND(DBMS_RANDOM.VALUE(1,6)));
         select count(*) into v_temp from students where v_preference1=v_preference2;
         exit when v_temp=0;
    END LOOP;
    
    v_temp:=0;
    LOOP
         v_preference3 := dorms_list(ROUND(DBMS_RANDOM.VALUE(1,6)));
         select count(*) into v_temp from students where v_preference1=v_preference3 or v_preference2 = v_preference3;
         exit when v_temp=0;
    END LOOP;
    
    v_temp:=0;
    LOOP
         v_preference4 := dorms_list(ROUND(DBMS_RANDOM.VALUE(1,6)));
         select count(*) into v_temp from students where v_preference1=v_preference4 or v_preference2 = v_preference4 or v_preference3=v_preference4;
         exit when v_temp=0;
    END LOOP;
    
    v_temp:=0;
    LOOP
         v_preference5 := dorms_list(ROUND(DBMS_RANDOM.VALUE(1,6)));
         select count(*) into v_temp from students where v_preference1=v_preference5 or v_preference2 = v_preference5 or v_preference3=v_preference5 or v_preference4=v_preference5;
         exit when v_temp=0;
    END LOOP;
    
    v_temp:=0;
    LOOP
         v_preference6 := dorms_list(ROUND(DBMS_RANDOM.VALUE(1,6)));
         select count(*) into v_temp from students where v_preference1=v_preference6 or v_preference2 = v_preference6 or v_preference3=v_preference6 or v_preference4=v_preference6 or v_preference5=v_preference6;
         exit when v_temp=0;
    END LOOP;
    
       
         -- id, student_id, faculty_id, faculty_name, last_name, first_name, year, average_grade,
-- SSN, email, phone, gender                  
      insert into students values(v_id, v_student_id, v_faculty_name, v_first_name, v_last_name, v_average_grade, 
                         v_email, v_phone, v_gen, v_preference1, v_preference2, v_preference3, v_preference4, v_preference5, v_preference6, v_dorm_id);
   END LOOP;
   DBMS_OUTPUT.PUT_LINE('Inserarea a 1025 studenti... GATA !');
END;

select first_name, last_name, s.faculty_id, faculty_name from students s join faculties_and_dorms f on s.faculty_id = f.faculty_id;
select faculty_name, d.dorm_id, dorm_name from faculties_and_dorms fd join dorms d on fd.dorm_id = d.dorm_id;

select * from students;
select dorm_id from students where student_id = '304BV6';
update students set dorm_id = null where student_id = '357AV3';
update students set dorm_id = null where student_id = '304BV6';
update students set dorm_id = null where student_id = '298IN8';
update students set dorm_id = null where student_id = '378QX5';

update faculties_and_dorms set rooms_girls_alloc = null where allocation_id = 27;
update faculties_and_dorms set rooms_girls_alloc = null where allocation_id = 28;
update faculties_and_dorms set rooms_girls_alloc = null where allocation_id = 29;
update faculties_and_dorms set rooms_girls_alloc = null where allocation_id = 30;
update faculties_and_dorms set rooms_girls_alloc = null where allocation_id = 25;

delete from students where student_id = 'N123AB4';
delete from students where student_id = 'N123K9';
commit;
select * from students order by average_grade desc;
select * from students order by id;
select * from dorms;
select * from faculties_and_dorms;
select count(*) from students;

select * from students where faculty_name = 'Faculty of Biology' order by average_grade desc;
update students set dorm_id = null;

commit;

/* am generat în baza de date 1025 de studenți cu informațiile corespunzătoare + popularea tabelelor dorms și faculties_and_dorms */






