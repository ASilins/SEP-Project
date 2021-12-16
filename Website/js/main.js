let calendar;
let lessons = [];
let input = document.getElementById('input');
let filter, value;


initCalendar();

function search() {
  lessons.forEach(function(item) {
    const selectButton = document.querySelector('#search_selector')

  })
}

fetch('../../src/Files/lessons.json')
.then(function(resp) {
  return resp.json();
})
.then(function(data) {
  
  data.lessons.forEach(function(item) {
    let titleName = item.course.courseName + item.course.semester + item.course.className + ' - ' + item.course.teacher1.initials + ' - ' + item.room.roomNumber;
    let startingTime;
    let endingTime;
    let startReacurence;
    let dayOftheWeek;

    if (item.timeSlot.dayOftheWeek == -1) {
    if (item.timeSlot.hourStart < 10 && item.timeSlot.hourEnd < 10) {
      startingTime = item.timeSlot.date + 'T0' + item.timeSlot.hourStart + ':' + item.timeSlot.minuteStart + ':00';
      endingTime = item.timeSlot.date + 'T0' + item.timeSlot.hourEnd + ':' + item.timeSlot.minuteEnd + ':00';
    } else if (item.timeSlot.hourStart < 10 && item.timeSlot.hourEnd >= 10) {
      startingTime = item.timeSlot.date + 'T0' + item.timeSlot.hourStart + ':' + item.timeSlot.minuteStart + ':00';
      endingTime = item.timeSlot.date + 'T' + item.timeSlot.hourEnd + ':' + item.timeSlot.minuteEnd + ':00';
    } else if (item.timeSlot.hourStart >= 10 && item.timeSlot.hourEnd < 10) {
      startingTime = item.timeSlot.date + 'T' + item.timeSlot.hourStart + ':' + item.timeSlot.minuteStart + ':00';
      endingTime = item.timeSlot.date + 'T0' + item.timeSlot.hourEnd + ':' + item.timeSlot.minuteEnd + ':00';
    } else if (item.timeSlot.hourStart >= 10 && item.timeSlot.hourEnd >= 10) {
      startingTime = item.timeSlot.date + 'T' + item.timeSlot.hourStart + ':' + item.timeSlot.minuteStart + ':00';
      endingTime = item.timeSlot.date + 'T' + item.timeSlot.hourEnd + ':' + item.timeSlot.minuteEnd + ':00';
    }

    addEvent({
      title: titleName,
      start: startingTime,
      end: endingTime,
    })
  } else {
    if (item.timeSlot.hourStart < 10 && item.timeSlot.hourEnd < 10) {
      startingTime = item.timeSlot.hourStart + ':' + item.timeSlot.minuteStart + ':00';
      endingTime = item.timeSlot.hourEnd + ':' + item.timeSlot.minuteEnd + ':00';
      startReacurence = item.timeSlot.date;
      dayOftheWeek = [item.timeSlot.dayOftheWeek];
    } else if (item.timeSlot.hourStart < 10 && item.timeSlot.hourEnd >= 10) {
      startingTime = item.timeSlot.hourStart + ':' + item.timeSlot.minuteStart + ':00';
      endingTime = item.timeSlot.hourEnd + ':' + item.timeSlot.minuteEnd + ':00';
      dayOftheWeek = [item.timeSlot.dayOftheWeek];
    } else if (item.timeSlot.hourStart >= 10 && item.timeSlot.hourEnd < 10) {
      startingTime = item.timeSlot.hourStart + ':' + item.timeSlot.minuteStart + ':00';
      endingTime = item.timeSlot.hourEnd + ':' + item.timeSlot.minuteEnd + ':00';
      dayOftheWeek = [item.timeSlot.dayOftheWeek];
    } else if (item.timeSlot.hourStart >= 10 && item.timeSlot.hourEnd >= 10) {
      startingTime = item.timeSlot.hourStart + ':' + item.timeSlot.minuteStart + ':00';
      endingTime = item.timeSlot.hourEnd + ':' + item.timeSlot.minuteEnd + ':00';
      dayOftheWeek = [item.timeSlot.dayOftheWeek];
    }

    addEvent({
      title: titleName,
      startTime: startingTime,
      endTime: endingTime,
      daysOfWeek: dayOftheWeek,
      startRecur: startReacurence,
    })
    }
  });

});

function initCalendar() {
  let calendarEl = document.getElementById('calendar');

  calendar = new FullCalendar.Calendar(calendarEl, {

    initialView: 'dayGridMonth',

    weekNumbers: true,
    weekNumberCalculation: 'ISO',
    
    navLinks: true,
    nowIndicator: true,
    dayMaxEvents: true,
    height: 'auto',
    stickyHeaderDates: false,

    headerToolbar: {
      left: 'dayGridMonth timeGridWeek timeGridDay',
      center: 'title',
      right: 'prev,today,next'
    },

    events: [],

  });

  calendar.render();
}

function addEvent(event) {
  calendar.addEvent(event);
  lessons.push(event);
}

function removeEvent(event) {
  calendar.removeEvent(event);
}