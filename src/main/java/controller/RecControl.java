package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import implimentation.Utility;
import model.RecModel;
import service.RecServiceImpl;

@RestController
public class RecControl {

	@Autowired
	RecServiceImpl recSerImpl;

	/*@EventListener
	public void onStartUp(ContextStartedEvent event) {
		FileReader fr;
		String[] entryData;
		String temp = "visitor_id";
		int i;
		try {
			fr = new FileReader("/home/bridgeit/contentDb.csv");
			BufferedReader br = new BufferedReader(fr);
			String entry;
			entry = br.readLine();
			entryData = entry.split("\\,");

			for (i = 0; i < entryData.length; i++) {
				System.out.print(i + " " + entryData[i] + " ");
			}

			while (entry != null) {
				entryData = entry.split("\\,");
				System.out.println(entry);
				for (i = 0; i < entryData.length; i++) {
					entryData[i] = entryData[i].replace("\"", "");
				}

				if (!(entryData[0].equals(temp))) {
					RecModel rm = new RecModel(entryData[0], entryData[1], entryData[2], entryData[3], entryData[4],
							entryData[5]);
					recSerImpl.addVisitor(rm);
				}
				entry = br.readLine();
			}
			System.out.println("Start map");
			recSerImpl.createContentIDMap();
			System.out.println();
			System.out.println("Exit");
			br.close();
			fr.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException ie) {
			// TODO Auto-generated catch block
			ie.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		// return "redirect:/get";
	}
*/
	@RequestMapping(value = "/getContent", headers = "Accept=application/json", method = RequestMethod.POST)
	public ModelAndView csvRead(@RequestBody String content, RedirectAttributes redirectAttibute) {
		System.out.println("Inside controller with contentId = " + content);
		Utility u = new Utility();
		RecModel record = u.fromJson(content);
		redirectAttibute.addFlashAttribute("recmodel", record);
		System.out.println("Outside");
		return new ModelAndView("redirect:/get");
	}

}