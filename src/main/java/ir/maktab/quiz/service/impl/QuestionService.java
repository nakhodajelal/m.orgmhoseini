package ir.maktab.quiz.service.impl;

import ir.maktab.quiz.model.domainmodel.*;
import ir.maktab.quiz.model.dto.QuestionDTO;

import ir.maktab.quiz.repo.*;
import ir.maktab.quiz.service.IQuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QuestionService implements IQuestionService {

    private final QuestionRepository questionRepository;
    private final MultipleChoiceQuestionRepository multipleChoiceQuestionRepository;
    private final DescriptiveQuestionRepository descriptiveQuestionRepository;
    private final ExamRepository examRepository;
    private final UserRepository userRepository;

    @Override
    public QuestionDTO addQuestionToExam(Long examId, QuestionDTO dto) {

        Exam exam = examRepository.findById(examId)
                .orElseThrow(() -> new RuntimeException("Exam not found with id: " + examId));

        User teacher = userRepository.findById(dto.getTeacherId())
                .orElseThrow(() -> new RuntimeException("Teacher not found with id: " + dto.getTeacherId()));

        Course course=exam.getCourse();

        Question question;

        if ("MULTIPLE_CHOICE".equals(dto.getQuestionType())) {
            MultipleChoiceQuestion multipleChoiceQuestion = new MultipleChoiceQuestion();
            multipleChoiceQuestion.setTitle(dto.getTitle());
            multipleChoiceQuestion.setText(dto.getText());
            multipleChoiceQuestion.setExam(exam);
            multipleChoiceQuestion.setTeacher(teacher);
            multipleChoiceQuestion.setCourse(course);
            question = multipleChoiceQuestionRepository.save(multipleChoiceQuestion);
        } else if ("DESCRIPTIVE".equals(dto.getQuestionType())) {

            DescriptiveQuestion descriptiveQuestion = new DescriptiveQuestion();
            descriptiveQuestion.setTitle(dto.getTitle());
            descriptiveQuestion.setText(dto.getText());
            descriptiveQuestion.setExam(exam);
            descriptiveQuestion.setTeacher(teacher);
            descriptiveQuestion.setCourse(course);
            descriptiveQuestion.setAnswerGuide(dto.getAnswerGuide());
            question = descriptiveQuestionRepository.save(descriptiveQuestion);
        } else {
            throw new RuntimeException("Invalid question type");
        }

        return new QuestionDTO(question);
    }

    @Override
    public List<QuestionDTO> getQuestionsByExam(Long examId) {
        List<Question> questions = questionRepository.findByExamId(examId);
        return questions.stream().map(QuestionDTO::new).collect(Collectors.toList());
    }

    @Override
    public QuestionDTO updateQuestion(Long questionId, QuestionDTO dto) {
        Question question = questionRepository.findById(questionId)
                .orElseThrow(() -> new RuntimeException("Question not found"));

        question.setTitle(dto.getTitle());
        question.setText(dto.getText());

        questionRepository.save(question);
        return new QuestionDTO(question);
    }

    @Override
    public void deleteQuestion(Long questionId) {
        questionRepository.deleteById(questionId);
    }

    @Override
    public List<QuestionDTO> getQuestionsByTeacher(Long teacherId) {
        List<Question> questions = questionRepository.findByTeacherId(teacherId);
        return questions.stream().map(QuestionDTO::new).collect(Collectors.toList());
    }
    @Override
    public List<QuestionDTO> getQuestionsByCourse(Long courseId) {
        List<Question> questions = questionRepository.findByCourseId(courseId);
        return questions.stream().map(QuestionDTO::new).collect(Collectors.toList());
    }

}
