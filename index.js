/**
 * @format
 */

import {AppRegistry, NativeModules} from 'react-native';
import App from './App';
import {name as appName} from './app.json';
import messaging from '@react-native-firebase/messaging';
const activityStarter = NativeModules.ActivityStarter;

messaging().setBackgroundMessageHandler(async remoteMessage => {
    console.log('Message handled in the background!', remoteMessage);
    return activityStarter.navigateToExample();
  });

AppRegistry.registerComponent(appName, () => App);
