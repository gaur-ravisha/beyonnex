package beyonnex.io;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AnagramTest {

@Test
void When_TwoTextsAreAnagrams_Expect_True() {

	Anagram anagram = new Anagram();
	assertTrue(anagram.checkIfTextsAreAnagrams("New York Times", "monkeys write"));
	assertTrue(anagram.checkIfTextsAreAnagrams("Church of Scientology", "rich-chosen goofy cult"));
	assertTrue(anagram.checkIfTextsAreAnagrams("McDonald's restaurants", "Uncle Sam's standard rot"));
	assertTrue(anagram.checkIfTextsAreAnagrams("coronavirus", "cArNiVoRoUs"));
	assertTrue(anagram.checkIfTextsAreAnagrams("\"Tom Marvolo Riddle\"", "I am Lord - Voldemort"));
	assertTrue(anagram.checkIfTextsAreAnagrams("bUcKeTheAd", "Death Cube K"));
	assertTrue(anagram.checkIfTextsAreAnagrams("\"AnnaMadrigal\"", "A man and a girl\""));
	assertTrue(anagram.checkIfTextsAreAnagrams("Lorin Morgan-Richards", "Marcil d'Hirson Garron"));
	assertTrue(anagram.checkIfTextsAreAnagrams("President Obama", "a baptism redone"));
	assertTrue(anagram.checkIfTextsAreAnagrams("silent", "LISTEN"));

	assertTrue(anagram.checkIfTextsAreAnagrams("xxx", "XXx"));
	assertTrue(anagram.checkIfTextsAreAnagrams("true lady", "adultery"));


}

@Test
void When_MoreThanTwoTextsAreAnagrams_Expect_True() {
	Anagram anagram = new Anagram();
	assertTrue(anagram.checkIfTextsAreAnagrams("She Sells Sanctuary", "Satan; cruel, less shy"));
	assertTrue(anagram.checkIfTextsAreAnagrams("She Sells Sanctuary", "Satan; cruel, less shy", "Santa; shy, less cruel"));
	assertTrue(anagram.checkIfTextsAreAnagrams("She Sells Sanctuary", "Satan; cruel, less shy", "Santa; shy, less cruel", "less SAnta-shy;cruel"));
	assertTrue(anagram.checkIfTextsAreAnagrams("She Sells Sanctuary", "Satan; cruel, less shy", "Santa; shy, less cruel", "less SAnta-shy;crue;l"));
	assertTrue(anagram.checkIfTextsAreAnagrams("", "", "   ", "	"));
}


@Test
void When_TextsAreNotAnagrams_Expect_False() {

	Anagram anagram = new Anagram();
	assertFalse(anagram.checkIfTextsAreAnagrams("case", "study"));
	assertFalse(anagram.checkIfTextsAreAnagrams("She Sells Sanctuary", "Satan; crueel, less shy", "Santa; shy, less cruel", "less SAnta-shy;crue;l"));
	assertFalse(anagram.checkIfTextsAreAnagrams("She Sells Sanctuary"));
	assertFalse(anagram.checkIfTextsAreAnagrams("She Sells Sanctuary", "Satan; cruel, less shy", "Santa; shyy, less cruel", "less SAnta-shy;cruel"));
	assertFalse(anagram.checkIfTextsAreAnagrams("She Sells Sanctuary", "Satan; cruel, less shy", "Santa; shx, less cruel", "less SAnta-shy;cruel"));
	assertFalse(anagram.checkIfTextsAreAnagrams("She Sells Sanctuary", "Satan; cruel, less shy", "Santa; shy, less cruel", "less SAntaa-shy;cruel"));
	assertFalse(anagram.checkIfTextsAreAnagrams("She Sells Sanctuary", "Satan; cruel, less shy", "Santa; shy, less cruel", "less SAnte-shy;cruel"));

}

}
