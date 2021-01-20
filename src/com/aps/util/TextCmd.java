package com.aps.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TextCmd {
	private String name;
	private String text;
	private ArrayList<String> opt;
	private ArrayList<Integer> history_input;
	private Map<String, TextCmd> all_texts;
	private static TextCmd text_cmd;
	
	private TextCmd() {
		all_texts = new HashMap<String, TextCmd>();
		history_input = new ArrayList<Integer>();
	}
	
	private TextCmd(String name, String text) {
		this.name = name;
		this.text = text;
	}
	
	private TextCmd(String name, String text, ArrayList<String> opt) {
		this.name = name;
		this.text = text;
		this.opt = opt;
	}	
	
	public static TextCmd Instance() {
		if (text_cmd == null) {
			text_cmd = new TextCmd();
		}
		return text_cmd;
	}
	
	public void add(String name, String text, ArrayList<String> cmd) {
		all_texts.put(name, new TextCmd(name, text, cmd));
	}

	public void add(String name, String text) {
		all_texts.put(name, new TextCmd(name, text));
	}
	
	public void textln(String name, String value, Boolean pos, int bn) {
		if (pos) {
			if (bn == 0) {
				System.out.print(this.all_texts.get(name).text+value);
			} else {
				System.out.print(this.all_texts.get(name).text+value+"\n".repeat(bn));
			}
		} else {
			if (bn == 0) {
				System.out.print(value+this.all_texts.get(name).text);	
			} else {				
				System.out.print(value+this.all_texts.get(name).text+"\n".repeat(bn));	
			}
		}
		
	}

	public void textln(String name, int bn) {
		System.out.print(this.all_texts.get(name).text+"\n".repeat(bn));
	}

	public void text(String name) {
		System.out.println(this.all_texts.get(name).text);		
	}

	public void text(String name, int value) {
		System.out.println(this.all_texts.get(name).text+value);		
	}
	
	public void text(String name, String value, Boolean pos) {
		if (pos) {
			System.out.println(this.all_texts.get(name).text+value);
		} else {
			System.out.println(value+this.all_texts.get(name).text);			
		}
	}
	
	public void opt(String name) {
		String all_opt = "";
		for (int i = 0; i < all_texts.get(name).opt.size(); i++) {
			all_opt += i+":"+all_texts.get(name).opt.get(i)+"\n";
		}
		System.out.print(all_opt+">");
	}

	public void opt_selected(String name, int id) {
		System.out.println(all_texts.get(name).opt.get(id));
	}
	
	public void _n(int n) {
		System.out.print("\n".repeat(n));
	}
 	
	public int selected(String name, String option) {
		for (int i = 0; i < all_texts.get(name).opt.size(); i++) {
			if (option.equals(Integer.toString(i)) || 
					option.toLowerCase().equals(all_texts.get(name).opt.get(i).toLowerCase())) {
				history_input.add(i);
				return i;
			}			
		}
		System.out.println("Por favor digite uma opção valida");
		return -1;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOpt(String name, int id) {
		return all_texts.get(name).opt.get(id);
	}

	public int getHistoryInput(int back) {
		if (history_input.size() - back>= 0) 
			return history_input.get(history_input.size() -1-back);
		return -1;
	}

	public int HistoryInput_remove_last() {
		if (history_input.size()> 0) 
			return history_input.remove(history_input.size()-1);
		return -1;
	}

	public void addOpt(String name, String opt) {
		all_texts.get(name).opt.add(opt);
	}
	
	public void clear_text() {			
		try {
			if (System.getProperty("os.name").contains("Windows"))
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			else {
				Runtime.getRuntime().exec("clear");
				System.out.println("\033[H\033[2J");
			}
		} catch (InterruptedException | IOException e) {
			e.printStackTrace();
		}
	}
}
