package mali.helo.bakingapp.model;

/** Represents a step needed to complete cooking recipe */
public class Step {
    private String mDescription;
    private String mShortDescription;
    private String mVideo;
    private String mThumbNail;
    private int mId;

    public Step(String description, String shortDescription, String video, String thumbNail, int id) {
        mDescription = description;
        mShortDescription = shortDescription;
        mVideo = video;
        mThumbNail = thumbNail;
        mId = id;
    }

    public String getDescription() {
        return mDescription;
    }

    public String getShortDescription() {
        return mShortDescription;
    }

    public String getVideo() {
        return mVideo;
    }

    public String getThumbNail() {
        return mThumbNail;
    }
}
