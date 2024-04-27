# RTCHack2024

[Demo video](https://devpost.com/software/book-buddy-rhsgj4)

## Instructions

Clone the repository and open the textbookshare folder in Android Studio (giraffe version). Try out the app using the built-in emulator of a Pixel 5 API 34 phone.

## Inspiration
The textbooks required for college classes can be very expensive, especially if you have multiple classes and have to buy a whole set of new ones each semester. As students on financial aid, we've experienced how much of a barrier this can be. We wanted to create an application that would allow textbook exchanging, lending, and selling within a campus in order to create a more affordable option for accessing textbooks and to empower students to create a community around helping each other out! 

## What it does

Our app essentially works like a community-based lending library for textbooks. You can search for the textbooks you need and find a list of users who have a copy of that book. You can also put your name and contact information down under any textbooks you own. From there, students can communicate amongst themselves the conditions of the exchange over email. New textbooks can be added to the library by users if the app doesn't have the book they're looking for.

## How we built it

We built our android application in Java using Android Studio, with GitHub for code sharing and version control.

## Challenges we ran into

A major challenge we ran into was that one of our teammates did not have experience with GitHub, and ran into a series of technical authorization issues trying to use it. After hours of trying to get it working, we ended up sharing code manually on Google Drive. We also faced trouble implementing data persistence, which would allow data sharing from one app session to the next and between users. In the end, we prioritized having a complete, functioning app rather than one with data persistence capabilities. On a brighter note, two challenges that we were able to overcome were figuring out how to implement a RecyclerView in Android Studio to display dynamic search results of textbooks and users, and figuring out a sorting algorithm to order our search results by relevance!

## Accomplishments that we're proud of

We are proud that we were able to create a functioning prototype in only 2 days! All of our teammates had limited to no experience with hackathons, but we had a great time building something from scratch. We are also proud of how we were able to manage our time well and have fun without getting too stressed.

## What we learned

We learned how to solve problems quickly and collaboratively. We also deepened our understanding of Java and Android app development as we explored tools and features we had never used before, especially in the area of UI.

## What's next for Book Buddy

Our next step would be to hook up our app to an SQL database or Google Firestore in order to share data between users over the internet. We would also want to add a Community tags to users' profiles so that students who are part of the same college, organization, or group can connect with each other!
