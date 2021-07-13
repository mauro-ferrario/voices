import React from 'react';
import {NativeModules, Button} from 'react-native';

const NewButton = () => {
  const onPress = () => {
    const {ScbNative, HelloWorld} = NativeModules;
    console.log('We will invoke the native module here!');
    console.log('----');
    console.log(ScbNative);
    ScbNative.sayHello().then((data) => {
      console.log('INSIDE PROMISE');
      console.log(data);
    });
  };

  return (
    <Button
      title="Click to invoke your native module!"
      color="#841584"
      onPress={onPress}
    />
  );
};

export default NewButton;