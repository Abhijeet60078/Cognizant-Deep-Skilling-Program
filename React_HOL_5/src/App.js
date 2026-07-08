import CohortDetails from './CohortDetails';

const cohorts = [
  {
    name: 'Java Full Stack',
    mentor: 'Priya',
    status: 'ongoing',
    batch: 'Cohort A',
    startDate: '2026-07-01',
    endDate: '2026-10-15'
  },
  {
    name: 'React Essentials',
    mentor: 'Arun',
    status: 'completed',
    batch: 'Cohort B',
    startDate: '2026-05-01',
    endDate: '2026-06-20'
  },
  {
    name: 'Cloud Foundations',
    mentor: 'Meera',
    status: 'completed',
    batch: 'Cohort C',
    startDate: '2026-04-10',
    endDate: '2026-05-30'
  }
];

function App() {
  return (
    <main className="page-shell">
      <section className="page-card">
        <h1>My Academy Cohort Dashboard</h1>
        <div className="cohort-grid">
          {cohorts.map((cohort) => (
            <CohortDetails key={`${cohort.name}-${cohort.batch}`} cohort={cohort} />
          ))}
        </div>
      </section>
    </main>
  );
}

export default App;
