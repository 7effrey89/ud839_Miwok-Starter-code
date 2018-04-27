package com.example.android.miwok;

/**
 * Created by Jeffrey on 05-03-2017.
 */

/**
 * {@link Word} represents a vocabulary word that the user wants to learn.
 * It contains a default translation and a Miwok translation for that word.
 */
public class Word {

    /**
     * Default translation for the word
     */
    private String mDefaultTranslation;
    /**
     * Miwok translation for the word
     */
    private String mMiwokTranslation;
    /**
     * Image resource ID for the word, setting it to not have a image. when it has this value will be overwritten
     */
    private int mImageResourceId = NO_IMAGE_PROVIDED;

    private static final int NO_IMAGE_PROVIDED = -1;
    /**
     * our contructor
     * <p>
     * Create a new Word object.
     *
     * @param defaultTranslation is the word in a language that the user is already familiar with
     *                           such as English)
     * @param miwokTranslation   is the word in the Miwok language
     */
    public Word(String DefaultTranslation, String MiwokTranslation) {
        mDefaultTranslation = DefaultTranslation;
        mMiwokTranslation = MiwokTranslation;
    }

    /**
     * Create a new Word object.
     *
     * @param defaultTranslation is the word in a language that the user is already familiar with
     *                           (such as English)
     * @param miwokTranslation   is the word in the Miwok language
     * @param imageResourceId    is the drawable resource ID for the image associated with the word
     */
    public Word(String DefaultTranslation, String MiwokTranslation, int ImageResourceId) {
        mDefaultTranslation = DefaultTranslation;
        mMiwokTranslation = MiwokTranslation;
        mImageResourceId = ImageResourceId;
    }

    /**
     * Get the default translation of the word.
     */
    public String getDefaultTranslation() {
        return mDefaultTranslation;
    }

    /**
     * Get the Miwok translation of the word.
     */
    public String getMiwokTranslation() {
        return mMiwokTranslation;
    }

    public int getImageResourceId() {

        return mImageResourceId;

    }
    public boolean hasImage(){
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }
}
