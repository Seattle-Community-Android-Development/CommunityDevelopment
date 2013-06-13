package com.example.groupproject;

/**
 * Created by toddfrisch on 5/27/13.
 */
public class ActionBarManager {

    public static final String EVENT_LIST_FRAGMENT = "EVENT_LIST_FRAGMENT";
    public static final String MY_EVENT_FRAGMENT = "MY_EVENT_FRAGMENT";
    public static final String MY_GROUPS_FRAGMENT = "MY_GROUPS_FRAGMENT";

//    public void initialize(Activity activity, int defaulIndex, int[] nameIDs, int[] fragmentIDs){ //look into if all of these are necessary
//
//        if (getActivity().getClass() == SingleViewActivity.class) {
//            ActionBar actionBar = getActivity().getActionBar();
//            actionBar.setDisplayShowTitleEnabled(false);
//            actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
//            ActionBar.Tab listTab = actionBar.newTab().setText(R.string.title_list).setTabListener(new TabListener<MapFragment>(getActivity(), "List View", MapFragment.class)
//            );
//            actionBar.addTab(listTab);
//            ActionBar.Tab mapTab = actionBar.newTab().setText(R.string.title_map).setTabListener(new TabListener<ListFragment>(getActivity(), "Map View", ListFragment.class)
//            );
//            actionBar.addTab(mapTab);
//
//            FragmentManager fm = getFragmentManager();
//            FragmentTransaction ft = fm.beginTransaction();
//
//
//        }
//
//    }
//
//    public static class TabListener <T extends Fragment> implements ActionBar.TabListener {
//        private Fragment mFragment;
//        private final Activity mActivity;
//        private final String mTag;
//        private final Class<T> mClass;
//
//        public TabListener(Activity activity, String tag, Class<T> clz) {
//            mActivity = activity;
//            mTag = tag;
//            mClass = clz;
//
//        }
//
//        @Override
//        public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
//
//            if(mFragment == null){
//                mFragment = Fragment.instantiate(mActivity, mClass.getName());
//                fragmentTransaction.replace(android.R.id.content, mFragment, mTag); //is content the correct thing to put in here? this had been .add
//            } else{
//                fragmentTransaction.attach(mFragment);
//            }
//
//        }
//
//        @Override
//        public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
//            if(mFragment != null){
//                fragmentTransaction.detach(mFragment);
//            }
//
//        }
//
//        @Override
//        public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
//
//        }
//    }
}
