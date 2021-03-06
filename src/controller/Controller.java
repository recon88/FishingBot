/*
 * Copyright 2017 Kevin Tyrrell
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software
 * and associated documentation files (the "Software"), to deal in the Software without restriction, 
 * including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense,
 * and/or sell copies of the Software, and to permit persons to whom the Software is furnished to
 * do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or 
 * substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 * FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS 
 * OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
 * WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR
 * IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package controller;

import static localization.Lang.Locale.*;

import model.singleton.Angler;

/*
 * Name: Kevin Tyrrell
 * Date: 7/22/2017
 */
public enum Controller
{
    INSTANCE;
    
    /** Listener who is listening in on sent messages. */
    private final Conversation mainConversation = new Conversation(), 
            debugConversation = new Conversation();

    /**
     * Alert the back-end to begin 
     * @return - True if the back-end was started.
     */
    public boolean start()
    {
        if (Angler.INSTANCE.isReady())
        {
            mainConversation.whisper(MSG_START.get());
            Angler.INSTANCE.fish();
            return true;
        }
        
        return false;
    }
    
    public boolean stop()
    {
        if (!Angler.INSTANCE.isReady())
        {
            mainConversation.whisper(MSG_END.get());
            Angler.INSTANCE.interrupt();
            return true;
        }
        
        return false;
    }

    /**
     * @return - The mainConversation.
     */
    public Conversation getMainConversation()
    {
        return mainConversation;
    }

    public Conversation getDebugConversation()
    {
        return debugConversation;
    }
}
