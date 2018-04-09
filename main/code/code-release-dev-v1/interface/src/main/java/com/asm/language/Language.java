package com.asm.language;

import com.asm.widget.codeedit.CodeEditInterface;
import com.asm.widget.codeedit.Highlightable;


/**
 * general interface for apply in CodeEdit.
 * You can make language easier to extends BaseLanguage.
 * @see com.asm.widget.codeedit.language.BaseLanuguage
 */
public interface Language
{
	/**
	 * Called when language initialize.
	 * Might called several times, when <code>CodeEdit.setLanguage()</code> several called.
	 */
	public void initLanguage(CodeEditInterface edit);
	
	/**
	 * Edit event that called before text changed.
	 */
	public void beforeTextChanged(CharSequence text, int start, int count, int after);
	/**
	 * Edit event that called after text changed.
	 */
	public void aftetTextChanged(CharSequence text, int start, int before, int count);
	
	/**
	 * Highlight the words from start to end.
	 * The call priority is beforeTextChanged -> afterTextChanged -> highlight. (when text changed)
	 * text changed event is run on UI thread, but highlight might be called
	 */
	public void highlight(Highlightable data, int start, int end);
	
	/**
	 * Return the language info.
	 */
	public LanguageInfo getInfo();
}
