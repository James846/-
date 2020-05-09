package com.wangpos.datastructure;

import android.content.ComponentName;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.wangpos.datastructure.core.DataBean;
import com.wangpos.datastructure.core.USList;
import com.wangpos.datastructure.core.WebViewActivity;
import com.wangpos.datastructure.graph.DjstaActivity;
import com.wangpos.datastructure.graph.GraphActivity;
import com.wangpos.datastructure.graph.TopologicalOrderActivity;
import com.wangpos.datastructure.interview.DesignV28Activity;
import com.wangpos.datastructure.java.JavaThreadActivity;
import com.wangpos.datastructure.java.JavaThreadPrincipleActivity;
import com.wangpos.datastructure.java.JavaThreadSummary;
import com.wangpos.datastructure.java.JavaWaitNotifyActivity;
import com.wangpos.datastructure.java.KeepMoreRequest;
import com.wangpos.datastructure.java.LockTestActivity;
import com.wangpos.datastructure.java.ReferenceQueueActivity;
import com.wangpos.datastructure.other.GetMinActivity;
import com.wangpos.datastructure.other.MaxSubStringActivity;
import com.wangpos.datastructure.sort.BinaryTreeActivity;
import com.wangpos.datastructure.sort.BisearchActivity;
import com.wangpos.datastructure.sort.BubbleSortActivity;
import com.wangpos.datastructure.sort.CountSortActivity;
import com.wangpos.datastructure.sort.DirectInsertSortActivity;
import com.wangpos.datastructure.sort.EasyLinkListActivity;
import com.wangpos.datastructure.sort.EasyLinkListReverseActivity;
import com.wangpos.datastructure.sort.EightSortDescriptionActivity;
import com.wangpos.datastructure.sort.HeapSortActivity;
import com.wangpos.datastructure.sort.MaxDataSelectDataActivity;
import com.wangpos.datastructure.sort.MaxMinSelectActivity;
import com.wangpos.datastructure.sort.MergeSortActivity;
import com.wangpos.datastructure.sort.OptionSortActivity;
import com.wangpos.datastructure.sort.QuickSortActivity;
import com.wangpos.datastructure.sort.RecursionActivity;
import com.wangpos.datastructure.sort.SelectIndexDataActivity;
import com.wangpos.datastructure.sort.ShellSortActivity;
import com.wangpos.datastructure.sort.SpaceComplexityActivity;
import com.wangpos.datastructure.sort.TimeComplexityActivity;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.ConnectionPool;
import okhttp3.Dispatcher;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;

import static com.wangpos.datastructure.core.BaseActivity.setWindowStatusBarColor;

public class MainActivity extends AppCompatActivity {

    public static final int Bisearch = 1;

    public static final int EasyLinkList = 2;

    public static final int ReverseEasyLinkList = 3;

    public static final int DirectInsertSort = 4;

    public static final int TimeComplexity = 5;

    public static final int SpaceComplexity = 6;

    public static final int QuickSort = 7;

    public static final int OptionSort = 8;

    public static final int binaryTreeSort = 9;

    public static final int BubbleSort = 10;

    public static final int JavaThread = 11;

    public static final int Recursion = 12;

    public static final int HeapSort = 13;

    public static final int MerageSort = 14;

    public static final int ShellSort = 15;

    public static final int EightSortDescription = 16;

    public static final int CountSort = 17;

    public static final int JavaThreadWaitNotify = 18;

    public static final int JavaThreadJoin = 19;

    public static final int MaxMinSelect = 20;

    public static final int RandomizedSelect = 21;

    public static final int MaxDataSelectData = 22;

    public static final int HashTable = 23;

    public static final int ToGitHub = 24;

    public static final int binarySearchTree = 25;

    public static final int Singleton = 26;

    public static final int TU = 27;

    public static final int JavaGC = 28;

    public static final int MAXSubString = 29;

    public static final int WaitMoreAsyncRequest = 30;

    public static final int Graph = 31;

    public static final int TopologicalSort = 32;

    public static final int Djsta = 33;

    public static final int JavaReferenceQueue = 34;

    public static final int JavaThreadPrinciple = 35;

    public static final int DesignV28 = 36;

    public static final int GetMin = 37;

    public static final int LOCKTEST = 38;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        setWindowStatusBarColor(this,R.color.colorPrimary);
        ListView mListView = (ListView)findViewById(R.id.listView);
        final ListAdapter adapter = new ListAdapter(this);
        USList<DataBean>list = new USList<>();

        initData(list);

        adapter.setDataBeanList(list);
        mListView.setAdapter(adapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                DataBean data = adapter.getDataBeanList().get(i);
                onClickItem(data);
            }
        });




    }

    private void onClickItem(DataBean data) {
        switch (data.type){
            case ToGitHub:
                launchWebView("https://github.com/UCodeUStory");
                break;
            case TimeComplexity:
                startActivity(new Intent(this,TimeComplexityActivity.class));
                break;
            case SpaceComplexity:
                startActivity(new Intent(this,SpaceComplexityActivity.class));
                break;
            case Bisearch:
                startActivity(new Intent(this, BisearchActivity.class));
                break;
            case EasyLinkList:
                startActivity(new Intent(this, EasyLinkListActivity.class));
                break;
            case ReverseEasyLinkList:
                startActivity(new Intent(this, EasyLinkListReverseActivity.class));
                break;
            case DirectInsertSort:
                startActivity(new Intent(this, DirectInsertSortActivity.class));
                break;
            case JavaThread:
                startActivity(new Intent(this, JavaThreadActivity.class));
                break;
            case JavaThreadWaitNotify:
                startActivity(new Intent(this, JavaWaitNotifyActivity.class));
                break;
            case QuickSort:
                startActivity(new Intent(this, QuickSortActivity.class));
                break;
            case binaryTreeSort:
                startActivity(new Intent(this, BinaryTreeActivity.class));
                break;
            case Recursion:
                startActivity(new Intent(this, RecursionActivity.class));
                break;
            case BubbleSort:
                startActivity(new Intent(this, BubbleSortActivity.class));
                break;
            case OptionSort:
                startActivity(new Intent(this, OptionSortActivity.class));
                break;
            case HeapSort:
                startActivity(new Intent(this, HeapSortActivity.class));
                break;
            case MerageSort:
                startActivity(new Intent(this, MergeSortActivity.class));
                break;
            case ShellSort:
                startActivity(new Intent(this, ShellSortActivity.class));
                break;
            case EightSortDescription:
                startActivity(new Intent(this, EightSortDescriptionActivity.class));
                break;
            case CountSort:
                startActivity(new Intent(this,CountSortActivity.class));
                break;
            case JavaThreadJoin:
                startActivity(new Intent(this, JavaThreadSummary.class));
                break;
            case MaxMinSelect:
                startActivity(new Intent(this, MaxMinSelectActivity.class));
                break;
            case RandomizedSelect:
                startActivity(new Intent(this, SelectIndexDataActivity.class));
                break;
            case MaxDataSelectData:
                startActivity(new Intent(this,MaxDataSelectDataActivity.class));
            case HashTable:
                launchWebView("https://github.com/UCodeUStory/DataStructure/blob/master/hashtable.md");
                break;
            case binarySearchTree:
                launchWebView("https://github.com/UCodeUStory/DataStructure/blob/master/sources/tree.md");
                break;
            case Singleton:
                launchWebView("https://github.com/UCodeUStory/DataStructure/blob/master/sources/singleInstance.md");
                break;
            case TU:
                launchWebView("https://github.com/UCodeUStory/DataStructure/blob/master/sources/tu.md");
                break;

            case JavaGC:
                launchWebView("https://github.com/UCodeUStory/DataStructure/blob/master/sources/JavaGarbageCollection.md");
                break;
            case MAXSubString:
                startActivity(new Intent(this, MaxSubStringActivity.class));
                break;

            case WaitMoreAsyncRequest:
                startActivity(new Intent(this, KeepMoreRequest.class));
                break;
            case Graph:
                startActivity(new Intent(this, GraphActivity.class));
                break;
            case TopologicalSort:
                startActivity(new Intent(this, TopologicalOrderActivity.class));
                break;
            case Djsta:
                startActivity(new Intent(this,DjstaActivity.class));
            case JavaReferenceQueue:
                startActivity(new Intent(this,ReferenceQueueActivity.class));
                break;
            case JavaThreadPrinciple:
                startActivity(new Intent(this,JavaThreadPrincipleActivity.class));
                break;
            case DesignV28:
                startActivity(new Intent(this,DesignV28Activity.class));
                break;
            case GetMin:
                startActivity(new Intent(this, GetMinActivity.class));
                break;
            case LOCKTEST:
                startActivity(new Intent(this, LockTestActivity.class));
            default:
                break;
        }

    }

    private void launchWebView(String s) {
        Intent tuIntent = new Intent(this, WebViewActivity.class);
        tuIntent.putExtra(WebViewActivity.EXTRA_URL, s);
        startActivity(tuIntent);
    }

    private void initData(USList<DataBean> list) {
        list.add(new DataBean(ToGitHub,"进入作者GitHub"));
        list.add(new DataBean(TimeComplexity,"时间复杂度介绍"));
        list.add(new DataBean(SpaceComplexity,"空间复杂度介绍"));
        list.add(new DataBean(Recursion,"递归与非递归区别和转换"));
        list.add(new DataBean(Bisearch,"折半查找／二分法查找"));
        list.add(new DataBean(EasyLinkList,"Java链表实现"));
        list.add(new DataBean(ReverseEasyLinkList,"反转一个链表"));
        list.add(new DataBean(DirectInsertSort,"直接插入排序"));
        list.add(new DataBean(QuickSort,"快速排序"));
        list.add(new DataBean(OptionSort,"选择排序"));
        list.add(new DataBean(binaryTreeSort,"二叉树排序"));
        list.add(new DataBean(binarySearchTree,"二叉树搜索树介绍"));
        list.add(new DataBean(BubbleSort,"冒泡排序"));
        list.add(new DataBean(JavaThread,"线程通信与锁详解"));
        list.add(new DataBean(JavaThreadWaitNotify,"Wait/notify/notifyAll"));
        list.add(new DataBean(JavaThreadJoin,"Join详解"));
        list.add(new DataBean(WaitMoreAsyncRequest,"等待多个异步请求完成"));
        list.add(new DataBean(Singleton,"最好的单例模式"));
        list.add(new DataBean(HeapSort,"堆排序"));
        list.add(new DataBean(MerageSort,"归并排序"));
        list.add(new DataBean(ShellSort,"希尔排序"));
        list.add(new DataBean(EightSortDescription,"八大排序总结"));
        list.add(new DataBean(CountSort, "计数排序"));
        list.add(new DataBean(MaxMinSelect,"快速找出最大值最小值算法"));
        list.add(new DataBean(RandomizedSelect,"随机选择法查找第k个数据"));
        list.add(new DataBean(MaxDataSelectData,"10亿数据选出前100数据"));
        list.add(new DataBean(HashTable,"散列表(哈希表)"));
        list.add(new DataBean(TU,"图详解"));
        list.add(new DataBean(JavaGC,"Java垃圾回收机制"));
        list.add(new DataBean(MAXSubString,"求最大不重复子串"));
        list.add(new DataBean(Graph,"图的算法"));
        list.add(new DataBean(TopologicalSort,"拓扑排序"));
        list.add(new DataBean(Djsta,"最短路径算法Djsta"));
        list.add(new DataBean(JavaReferenceQueue,"ReferenceQueue"));
        list.add(new DataBean(JavaThreadPrinciple,"Java线程池原理"));
        list.add(new DataBean(DesignV28,"AndroidDesignV28新增内容"));
        list.add(new DataBean(GetMin,"通过栈实现获取最小值"));
        list.add(new DataBean(LOCKTEST,"LOCK使用"));

        //Debug

//        list.add(0,list.get(list.size()-1));


    }
}
