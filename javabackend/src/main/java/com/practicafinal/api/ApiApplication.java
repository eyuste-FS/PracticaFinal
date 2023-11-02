package com.practicafinal.api;

import com.practicafinal.api.embeddables.EmpleadosProyectoId;
import com.practicafinal.api.models.response.Empleado;
import com.practicafinal.api.models.response.EmpleadosProyecto;
import com.practicafinal.api.models.response.Proyecto;
import com.practicafinal.api.repositories.EmpleadoRepository;
import com.practicafinal.api.repositories.EmpleadosProyectoRepository;
import com.practicafinal.api.repositories.ProyectoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunnerGenerator(
			EmpleadoRepository empleadoRepository,
			ProyectoRepository proyectoRepository,
			EmpleadosProyectoRepository empleadosProyectoRepository) {
		return args -> {

			String[][] empleados = {
			{"43807951L", "Jason", "Rodriquez", "Grant", "1972-08-13", "783800640", "966981589", "ga@puto.ve", "2014-02-07", null, "C", "S"},
			{"36687650C", "Willie", "Murray", "Morris", "1990-05-07", "706846503", "946255738", "opiame@wondop.il", "2019-03-30", "2022-02-27", "C", "N"},
			{"43671160V", "Jane", "Arnold", "McGee", "2001-02-22", "107288826", "807600019", "el@wogcus.jp", "2010-01-15", null, "S", "N"},
			{"67857294P", "Lenora", "Harmon", "Mills", "1987-05-27", "652164965", "636085116", "fa@raob.tz", "2019-11-22", null, "S", "N"},
			{"48253224R", "Chris", "Price", "Peterson", "1960-12-27", "142707052", "880921751", "laude@bor.cd", "2016-12-25", null, "S", "N"},
			{"49926273J", "Luis", "Wallace", "Patrick", "1990-04-25", "576427657", "884486290", "gihvujna@jo.my", "2009-02-12", "2019-01-08", "S", "N"},
			{"25693157B", "Clarence", "Todd", "Perkins", "1987-01-20", "400866700", "490723011", "ow@usibo.bj", "2011-10-08", null, "S", "S"},
			{"71837512S", "Harriet", "Pope", "Rodgers", "1997-02-01", "956346912", "226332495", "tatula@we.tw", "2015-09-01", "2021-09-21", "C", "N"},
			{"71461136O", "Noah", "Garrett", "Allen", "1964-12-22", "761844921", "917867753", "lu@uziniej.cr", "2009-01-26", "2021-05-23", "C", "N"},
			{"44854649F", "Aaron", "Soto", "Ramsey", "1974-08-01", "294103598", "982760054", "efdilcug@omfej.mq", "2010-06-16", "2020-08-22", "S", "N"},
			{"36216344Z", "Dennis", "Walters", "Chavez", "1974-12-29", "260516750", "488057301", "voh@rawif.uz", "2017-11-20", "2021-05-28", "S", "N"},
			{"16717195Q", "Alice", "Gilbert", "Figueroa", "1976-11-28", "506340617", "457149154", "tusitow@fico.ao", "2016-07-14", "2023-06-10", "C", "S"},
			{"81988285A", "Harold", "Long", "Washington", "1961-04-26", "301791063", "762703124", "odpav@kevuane.tw", "2005-02-09", "2022-10-26", "S", "N"},
			{"78288280R", "Lulu", "Bridges", "Hart", "1981-08-20", "736070349", "129527806", "tag@heiwuad.ch", "2017-09-20", "2020-05-14", "S", "N"},
			{"59890468N", "Frederick", "Brooks", "Flowers", "1982-12-16", "445552271", "356411987", "he@bizbujak.fi", "2010-10-28", "2023-03-03", "C", "S"},
			{"55835342S", "Ann", "Harrison", "Strickland", "1993-09-01", "632359638", "350802921", "badzosa@ik.td", "2010-02-27", null, "S", "N"},
			{"88971625F", "Anthony", "Bryant", "Fowler", "2002-08-25", "842291751", "399259753", "ukbefaj@muhbinu.dz", "2011-04-17", "2019-10-16", "S", "N"},
			{"72714143Q", "Antonio", "Jefferson", "Brooks", "1988-11-28", "845741615", "726701713", "jeg@raunanu.ba", "2005-06-08", null, "C", "N"},
			{"11544122Z", "Bernice", "Taylor", "Leonard", "1966-04-08", "875277126", "587499645", "avi@halriz.sb", "2015-07-15", null, "S", "S"},
			{"97876603F", "Norman", "Lindsey", "Gomez", "1995-06-26", "568265556", "693866256", "koguwbuh@zozag.is", "2012-12-31", null, "C", "N"},
			{"24777237Q", "Phoebe", "Welch", "Walton", "1992-08-30", "854346654", "796995502", "egfivim@uli.si", "2005-05-17", "2019-08-24", "C", "S"},
			{"34231944Q", "Julia", "Gross", "Harrington", "1991-05-14", "946669442", "949734255", "mu@ogasod.ca", "2008-02-13", "2019-09-25", "S", "N"},
			{"10922250Q", "Luella", "Schwartz", "Sutton", "1967-03-03", "402658931", "305258902", "oz@cizob.sx", "2011-11-21", "2023-01-08", "C", "S"},
			{"96426873A", "Josephine", "Hunt", "Daniels", "1995-12-27", "231227235", "720771427", "sinvo@vigair.lr", "2006-10-16", null, "S", "N"},
			{"72822038K", "Isabella", "Barker", "Wheeler", "1963-04-17", "552014046", "348856181", "lin@sic.fj", "2013-06-30", null, "S", "S"},
			{"55031525L", "Dustin", "Reid", "Anderson", "1983-07-16", "702127713", "822452477", "kek@umidgo.me", "2008-12-06", null, "C", "S"},
			{"58712323P", "Mamie", "Gill", "Norton", "1997-12-29", "647393532", "775552485", "izga@nud.bv", "2011-02-13", "2020-01-19", "S", "S"},
			{"88706275W", "Elnora", "Fleming", "Herrera", "2004-05-27", "578692521", "156386726", "jeupazo@jamup.gp", "2014-12-19", null, "S", "N"},
			{"36753734T", "Andrew", "Hamilton", "Pope", "1992-07-29", "915691459", "630220093", "bi@kiz.co", "2020-03-05", "2021-10-16", "C", "S"},
			{"14236794L", "Gavin", "Carlson", "Dean", "1979-02-02", "676703048", "643631389", "wewo@hawavun.id", "2010-09-09", null, "C", "N"},
			{"25166633E", "Ralph", "Mendez", "Owens", "1990-01-02", "713897773", "578398485", "monu@dekewu.np", "2005-05-28", "2023-05-10", "S", "S"},
			{"42508323P", "Nina", "Rogers", "Santos", "1968-04-28", "428145909", "406570556", "awaigu@boh.vi", "2017-09-20", null, "C", "S"},
			{"55318047D", "Samuel", "Barton", "Benson", "1981-02-13", "918518400", "802639175", "anufad@aguse.gq", "2015-09-13", "2021-05-30", "S", "S"},
			{"24581645M", "Angel", "Hammond", "Thomas", "1961-09-14", "733610263", "823961008", "jipi@uzuktig.hu", "2010-07-30", "2020-11-05", "S", "S"},
			{"57392196O", "Mabelle", "Drake", "Wright", "2001-08-11", "524549629", "878141008", "locpake@de.de", "2011-11-01", "2022-01-24", "C", "S"},
			{"33653037Q", "Harry", "Hall", "Ray", "1990-10-12", "632693083", "943525897", "izi@dadit.ht", "2019-06-15", "2020-03-09", "S", "S"},
			{"38399052H", "Katie", "Stanley", "Hall", "1963-01-10", "116054361", "505869564", "fumaknet@ma.de", "2016-09-16", "2019-10-20", "S", "N"}};

			List<Empleado> empleadosL = new ArrayList<Empleado>();
			for (String[] row: empleados){
				empleadosL.add(new Empleado(
						row[0], row[1], row[2], row[3],
						row[4] == null ? null: LocalDate.parse(row[4]),
						row[5], row[6], row[7],
						row[8] == null ? null: LocalDate.parse(row[8]),
						row[9] == null ? null: LocalDate.parse(row[9]),
						row[10].charAt(0), row[11].charAt(0)
				));
			}
			empleadoRepository.saveAll(empleadosL);

			String[][] proyectos = {
			{"descripcion", "2021-02-15", null, null, "lugar", "observaciones"},
			{"descripcion2", "2021-02-16", null, null, "lugar2", "observaciones2"},
			{"descripcion3", "2021-02-17", null, null, "lugar3", "observaciones3"},
			{"occur both black copper saw excellent mind doctor decide completely ", "2007-08-01", null, null, "Cedoli", "atomic refer gold then information twelve castle parent plant duty yes paint sharp between rough basic somewhere pan high political entirely curious vast additional"},
			{"love smaller aside cow there air speed pan nature wore base", "2007-08-08", null, null, "Gefazgah", "noun arm finest memory tears move like dear cabin beside student pet himself which unhappy men pond rise sell jet circle knife motor accept"},
			{"mistake forgot let way control charge hundred indeed smell describ", "2020-11-22", null, null, "Dezjezso", "necessary progress fill us think for sometime drink useful column nuts massage kind how population fun generally break cat magnet without vegetable theory row"},
			{"bean any failed softly than engineer changing college upon manufacturing view", "2022-09-16", null, null, "Utipiaje", "myself troops start laugh shore tide string level red aboard stronger some journey cutting order pressure soon sort prize fall follow blue image lady"},
			{"think factor cap grass bill agree nearest positive fast exercise believed obtain d", "2020-07-07", null, null, "Venavadir", "finger progress know missing needle joined great independent sitting band fence refer bent pure movement she history shorter tube by paper spoken suit nobody"},
			{"purple cup remember additional drink vegetable library wool bill graph mirror go", "2020-12-25", null, null, "Dirolgi", "we basic sunlight dirty at tent molecular occasionally charge per cloth reader bright indeed during tired whatever him planet clothes dull sun track pound"},
			{"picture fifth note announced feed purple valuable seldom twenty bark bow constructi", "2009-08-12", null, null, "Jurjubbob", "replace judge low four phrase quietly glad transportation space barn typical well frozen ten finish known nine operation driving measure wash dog additional distance"},
			{"near flew condition own health step both heading mathematics discuss organized syllable ", "2019-08-07", null, null, "Eguocuru", "dust yourself possible needs swimming first monkey religious south question milk card tube fort bet twice being carefully these sail serve rule master other"},
			{"picture work iron football visit flat customs trap expect has bit mile forth branch wh", "2012-08-05", null, null, "Lumawem", "ground work coffee age good surrounded noon girl block hungry afraid cake establish prize glass announced honor few primitive fog importance aware safe comfortable"},
			{"dull act get question music four height grass clearly got pres", "2007-08-14", null, null, "Lazotrus", "appearance above mud middle move golden log oldest song fight brick bone birth this writer willing cave clothes protection mine guess tears anybody food"},
			{"method receive tin mass actually gift rose chapter information six condition", "2022-05-06", null, null, "Ijlenu", "consider farther get believed sun yes cookies wonder laugh obtain over name oil onto tales price choice shown listen branch particularly tonight shinning importance"},
			{"fifth solve fireplace across stuck care poor jack got wealth tobacc", "2005-06-09", null, null, "Daswetlog", "fat rubbed shallow effect rose mud lie girl cause ice road clear line low mighty buy consonant hurry daily degree minerals brave alike research"},
			{"snake political outline accept purpose noon skill foreign daily wall private somewhere quick ", "2005-09-10", null, null, "Enlovfir", "has particularly swing along planet depth grain fly does birth capital conversation by noted taught customs gone yesterday though hidden stiff husband movie alphabet"}
			};
			
			List<Proyecto> proyectosL = new ArrayList<Proyecto>();
			for (String[] row: proyectos){
				proyectosL.add(new Proyecto(
						row[0],
						row[1] == null ? null: LocalDate.parse(row[1]),
						row[2] == null ? null: LocalDate.parse(row[2]),
						row[3] == null ? null: LocalDate.parse(row[3]),
						row[4], row[5]
				));
			}
			proyectoRepository.saveAll(proyectosL);

			String[][] asignaciones = {
			{"1", "1", "2022-10-01"},
			{"2", "1", "2022-10-02"},
			{"2", "2", "2022-10-04"},
			{"3", "2", "2022-10-04"},
			{"13", "5", "2013-08-13"},
			{"15", "7", "2006-02-18"},
			{"15", "11", "2008-02-08"},
			{"3", "14", "2005-11-21"},
			{"9", "14", "2020-07-03"},
			{"11", "14", "2008-03-20"},
			{"15", "14", "2007-07-27"},
			{"5", "16", "2011-10-28"},
			{"9", "17", "2023-12-07"},
			{"9", "18", "2023-07-23"},
			{"14", "18", "2013-04-25"},
			{"11", "20", "2008-02-09"},
			{"13", "20", "2007-07-11"},
			{"8", "21", "2019-03-26"},
			{"11", "22", "2007-03-29"},
			{"14", "22", "2008-04-15"},
			{"3", "24", "2018-01-02"},
			{"4", "24", "2008-02-05"},
			{"7", "26", "2017-07-29"},
			{"8", "26", "2015-06-28"},
			{"14", "27", "2023-01-08"},
			{"6", "28", "2018-11-24"},
			{"8", "28", "2020-01-25"},
			{"6", "29", "2020-06-27"},
			{"10", "31", "2018-05-16"},
			{"11", "31", "2008-11-26"},
			{"3", "32", "2012-07-15"},
			{"3", "4", "2005-03-16"},
			{"16", "13", "2006-08-30"},
			{"14", "34", "2019-03-07"},
			{"2", "35", "2019-06-16"},
			{"8", "36", "2015-11-09"},
			{"10", "37", "2022-09-29"},
			{"11", "37", "2014-06-19"}
			};

			List<EmpleadosProyecto> empleadosProyectos = new ArrayList<EmpleadosProyecto>();
			for (String[] row: asignaciones){
				Long pid = Long.parseLong(row[0]), eid = Long.parseLong(row[1]);
				Proyecto p = proyectoRepository.getReferenceById(pid);
				Empleado e = empleadoRepository.getReferenceById(eid);
				empleadosProyectos.add(new EmpleadosProyecto(
						new EmpleadosProyectoId(e, p),
						row[2] == null ? null: LocalDate.parse(row[2])
				));
			}
			empleadosProyectoRepository.saveAll(empleadosProyectos);
			
		};
	}
}
