package rxtest;

import rx.Observable;
import rx.Subscription;
import rx.functions.Action1;
import rx.subjects.PublishSubject;
import rx.subjects.Subject;

public class App {
    public static void main(String[] args) {
        final AutoCloseOperator<MyResource> autoClose = new AutoCloseOperator<MyResource>();
        Subject<MyResource, MyResource> subject = PublishSubject.create();
        Observable<MyResource> o = subject.lift(autoClose);

        Subscription s1 = o.subscribe(new Action1<MyResource>() {
            public void call(MyResource myObj) {
                System.out.println("s1 handling " + myObj);
            }
        });

        subject.onNext(new MyResource(1));
        subject.onNext(new MyResource(2));

        Subscription s2 = o.subscribe(new Action1<MyResource>() {
            public void call(MyResource myObj) {
                System.out.println("s2 handling " + myObj);
            }
        });

        subject.onNext(new MyResource(3));
        subject.onNext(new MyResource(4));

        s1.unsubscribe();

        subject.onNext(new MyResource(5));
        subject.onNext(new MyResource(6));

        s2.unsubscribe();

        subject.onNext(new MyResource(7));
        subject.onNext(new MyResource(8));

        /*
        Output:

        s1 handling Resource #1
        s1 handling Resource #2
        Closing Resource #1
        s1 handling Resource #3
        Closing Resource #2
        s2 handling Resource #3
        s1 handling Resource #4
        s2 handling Resource #4
        Closing Resource #3
        s2 handling Resource #5
        Closing Resource #4
        s2 handling Resource #6
        Closing Resource #5
        Closing Resource #6
        Closing Resource #7
         */
    }
}
